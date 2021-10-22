package sia;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FluxCreationTests {

    // Flux 생성 후 구독자한테 보내기
    @Test
    public void createAFlux_just(){
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        fruitFlux.subscribe(
                f -> System.out.println("Here's some fruit: " + f)
        );
    }

    // 배열로부터 생성
    @Test
    public void createAFlux_fromArray(){
        String[] fruits = new String[]{
                "Apple", "Orange", "Grape", "Banana", "Strawberry"
        };
        Flux<String> fruitFlux = Flux.fromArray(fruits);

        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    // List, Set, Iterable의 다른 구현 컬렉션으로부터 Flux 생성 시
    @Test
    public void createAFlux_fromIterable(){
        List<String> fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Orange");
        fruitList.add("Grape");
        fruitList.add("Banana");
        fruitList.add("Strawberry");

        Flux<String> fruitFlux = Flux.fromIterable(fruitList);
        // 검사 코드 작성 가능
    }

    // Flux 생성 소스로 Stream 객체 사용
    @Test
    public void createAFlux_fromStream(){
        Stream<String> fruitStream = Stream.of("Apple", "Orange", "Grape", "Banana", "Strawberry");
        Flux<String> fruitFlux = Flux.fromStream(fruitStream);
        // 검사 코드
    }

    // 카운터 역할의 Flux
    @Test
    public void createAFlux_range(){
        Flux<Integer> intervalFlux = Flux.range(1, 5);
        StepVerifier.create(intervalFlux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .verifyComplete();
    }

    // 매초마다 값 방출 & limit 가능, *값이 증가*
    @Test
    public void createAFlux_interval(){
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1)).take(5);
        StepVerifier.create(intervalFlux)
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L)
                .verifyComplete();
    }
}
