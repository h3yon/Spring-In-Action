package sia;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import java.time.Duration;

public class FluxMergingTests {

    // mergeWith: 번갈아가면서
    @Test
    public void mergeFluxes(){
        Flux<String> characterFlux = Flux
                .just("개구리", "개굴", "올챙이")
                .delayElements(Duration.ofMillis(500));
        Flux<String> foodFlux = Flux
                .just("고기", "치킨", "집밥")
                .delaySubscription(Duration.ofMillis(250)) //조금 느리게 방출되도록
               .delayElements(Duration.ofMillis(500));

        Flux<String> mergedFlux = characterFlux.mergeWith(foodFlux);
        StepVerifier.create(mergedFlux)
                .expectNext("개구리")
                .expectNext("고기")
                .expectNext("개굴")
                .expectNext("치킨")
                .expectNext("올챙이")
                .expectNext("집밥")
                .verifyComplete();
    }

    // zip: 둘을 하나로 합쳐버리기(정적)
    // 튜플 2개 zip
    @Test
    public void zipFluxes(){
        Flux<String> characterFlux = Flux.just("개구리", "개굴", "올챙이");
        Flux<String> foodFlux = Flux.just("고기", "치킨", "집밥");
        Flux<Tuple2<String, String>> zippedFlux = Flux.zip(characterFlux, foodFlux);

        StepVerifier.create(zippedFlux)
                .expectNextMatches(p ->
                        p.getT1().equals("개구리") &&
                        p.getT2().equals("고기"))
                .expectNextMatches(p ->
                        p.getT1().equals("개굴") &&
                        p.getT2().equals("치킨"))
                .expectNextMatches(p ->
                        p.getT1().equals("올챙이") &&
                        p.getT2().equals("집밥"))
                .verifyComplete();
    }

    // zip: String 객체의 Flux
    @Test
    public void zipFluxesToObject(){
        Flux<String> characterFlux = Flux.just("개구리", "개굴", "올챙이");
        Flux<String> foodFlux = Flux.just("고기", "치킨", "집밥");
        Flux<String> zippedFlux = Flux.zip(characterFlux, foodFlux, (c, f) -> c + " eats " + f);

        StepVerifier.create(zippedFlux)
                .expectNext("개구리 eats 고기")
                .expectNext("개굴 eats 치킨")
                .expectNext("올챙이 eats 집밥")
                .verifyComplete();
    }

    // 먼저 값 방출
    @Test
    public void FirstFlux(){
        Flux<String> slowFlux = Flux.just("개구리", "개굴", "올챙이")
                .delaySubscription(Duration.ofMillis(100));
        Flux<String> fastFlux = Flux.just("빠른 개구리", "빠른 개굴", "빠른 올챙이");
        Flux<String> firstFlux = Flux.first(slowFlux, fastFlux);

        StepVerifier.create(firstFlux)
                .expectNext("빠른 개구리")
                .expectNext("빠른 개굴")
                .expectNext("빠른 올챙이")
                .verifyComplete();
    }


}
