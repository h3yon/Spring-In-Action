package sia;

import lombok.Data;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class FluxTransformingTests {

    @Test
    public void skipAFew() {
        Flux<String> skipFlux = Flux
                .just("1", "2", "skip a few", "99", "100")
                .skip(3);
        StepVerifier.create(skipFlux)
                .expectNext("99", "100")
                .verifyComplete();
    }

    // 4초 동안 기다렸다가 값을 방출. 항목 간에 1초 동안 지연
    @Test
    public void skipAFewSeconds() {
        Flux<String> skipFlux = Flux
                .just("1", "2", "skip a few", "99", "100")
                .delayElements(Duration.ofSeconds(1))
                .skip(Duration.ofSeconds(4));
        StepVerifier.create(skipFlux)
                .expectNext("99", "100")
                .verifyComplete();
    }

    @Test
    public void take() {
        Flux<String> alphabetFlux = Flux
                .just("A", "B", "C", "D", "E")
                .take(3);
        StepVerifier.create(alphabetFlux)
                .expectNext("A", "B", "C")
                .verifyComplete();
    }

    @Test
    public void take1() {
        Flux<String> alphabetFlux = Flux
                .just("A", "B", "C", "D", "E")
                .delayElements(Duration.ofSeconds(1))
                .take(Duration.ofMillis(3500));
        StepVerifier.create(alphabetFlux)
                .expectNext("A", "B", "C")
                .verifyComplete();
    }

    @Test
    public void filter() {
        Flux<String> alphabetFlux = Flux
                .just("AA", "BB", "C  C", "DD", "E  E")
                .filter(np -> !np.contains(" "));
        StepVerifier.create(alphabetFlux)
                .expectNext("AA", "BB", "DD")
                .verifyComplete();
    }

    @Test
    public void distinct() {
        Flux<String> alphabetFlux = Flux
                .just("A", "B", "C", "A", "B", "C", "D", "E")
                .distinct();
        StepVerifier.create(alphabetFlux)
                .expectNext("A", "B", "C", "D", "E")
                .verifyComplete();
    }

    @Test
    public void map() {
        Flux<Player> playerFlux = Flux
                .just("A Player", "B Player", "C Player")
                .map(n -> {
                    String[] split = n.split("\\s");
                    return new Player(split[0], split[1]);
                });
        StepVerifier.create(playerFlux)
                .expectNext(new Player("A", "Player"))
                .expectNext(new Player("B", "Player"))
                .expectNext(new Player("C", "Player"))
                .verifyComplete();
    }

    @Test
    public void flatMap(){
        Flux<Player> playerFlux = Flux
                .just("A Player", "B Player", "C Player")
                .flatMap(n -> Mono
                        .just(n)
                        .map(p -> {
                            String[] split = p.split("\\s");
                            return new Player(split[0], split[1]);
                        })
                        .subscribeOn(Schedulers.parallel())
                        // 각 구독이 병렬 스레드로 수행되어야 한다
                );
        List<Player> playerList = Arrays.asList(
                new Player("A", "Player"),
                new Player("B", "Player"),
                new Player("C", "Player"));
        StepVerifier.create(playerFlux)
                .expectNextMatches(p -> playerList.contains(p))
                .expectNextMatches(p -> playerList.contains(p))
                .expectNextMatches(p -> playerList.contains(p))
                .verifyComplete();
    }

    @Data
    private static class Player {
        private final String firstName;
        private final String lastName;
    }
}
