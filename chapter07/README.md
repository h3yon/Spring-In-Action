# ๐ฅ6์ฅ REST ์๋น์ค ์์ฑํ๊ธฐ
## ๐์ด ์ฅ์์ ๋ฐฐ์ฐ๋ ๋ด์ฉ
- ์คํ๋ง MVC์์ REST ์๋ํฌ์ธํธ ์ ์ํ๊ธฐ
- ํ์ดํผ๋งํฌ REST ๋ฆฌ์์ค ํ์ฑํํ๊ธฐ
- ๋ ํฌ์งํ ๋ฆฌ ๊ธฐ๋ฐ์ REST์๋ํฌ์ธํธ ์๋ํ

## ๐์คํ๋ง์ต์ ๋ฒ์  ์ฌ์ฉ์ hateoas ์ฑ๊ณผ ๋ค๋ฅธ ๋ณ๊ฒฝ์ฌํญ
- `ResourceSupport` changed to `RepresentationModel`
- `Resource` changed to `EntityModel`
- `Resources` changed to `CollectionModel`
- `PagedResources` changed to `PagedModel`
- `ResourceAssembler` changed to `RepresentationModelAssembler`
- `ControllerLinkBuilder` changed to `WebMvcLinkBuilder`
- `ResourceProcessor` changed to `RepresentationModelProcessor`
## ๐์ด ๋ ํฌ์งํ ๋ฆฌ์์๋ ๋ณ๊ฒฝ๋ด์ฉ์ ๋ฐ์ํด ์์ฑํ๊ฒ ์ต๋๋ค
### ๐์คํ๋ง๋ถํธ ๊ตฌ๋ฒ์ ผ ์ฌ์ฉํ ๊ฒฝ์ฐ ๋ณ๊ฒฝํ์ง ์์๋ ๋จ.
์ด๋ฒ ์ฅ์์๋ ์คํ๋ง์ ์ฌ์ฉํด์ ํ์ฝํด๋ผ์ฐ๋ ์ ํ๋ฆฌ์ผ์ด์์ REST API๋ฅผ ์ ๊ณตํ ๊ฒ์ด๋ค. ์ด๋ ์คํ๋ง MVC ์ปจํธ๋กค๋ฌ๋ฅผ ์ฌ์ฉํด์

REST ์๋ํฌ์ธํธ๋ฅผ ์์ฑํ๊ธฐ ์ํด 2์ฅ์์ ๋ฐฐ์ ๋ MVC๋ฅผ ์ฌ์ฉํ๋ค. ๋ํ, 4์ฅ์์ ์ ์ํ๋ ์คํ๋ง ๋ฐ์ดํฐ ๋ ํฌ์งํ ๋ฆฌ์ REST

์๋ํฌ์ธํธ๋ ์ธ๋ถ์์ ์ฌ์ฉํ  ์ ์๊ฒ ์๋์ผ๋ก ๋ธ์ถ์ํจ๋ค. ๋ง์ง๋ง์ผ๋ก, ๊ทธ๋ฐ ์๋ํฌ์ธํธ๋ฅผ ํ์คํธํ๊ณ  ์์ ํ๊ฒ ๋ง๋๋ ๋ฒ์ ์์๋ณธ๋ค

## ๐REST์ปจํธ๋กค๋ฌ ์์ฑํ๊ธฐ

์ด ์ฑ์์๋ ์ต๊ทค๋ฌ ํ๋ ์์ํฌ๋ฅผ ์ฌ์ฉํด์ SPA๋ก ํ๋ก ํธ์๋๋ฅผ ๊ตฌ์ถํ๋ค. ์ด์ฑ์ ๋ชฉ์ ์ ์ต๊ทค๋ฌ๊ฐ์๋๋ฏ๋ก ํต์ฌ์ ๋ฐฑ์๋

์คํ๋ง ์ฝ๋์ ์ด์ ์ ๋ ๊ฒ์ด๋ค.

### ๐์๋ฒ์์ ๋ฐ์ดํฐ ๊ฐ์ ธ์ค๊ธฐ

๊ฐ์ฅ ์ต๊ทผ์ ์์ฑ๋ ํ์ฝ๋ฅผ ๋ณด์ฌ์ฃผ๋ RecentTacosComponent๋ฅผ ์ต๊ทค๋ฌ ์ฝ๋์ ์ ์ํ์๋ค.
```
//์ต๊ทผ ํ์ฝ๋ค์ ๋ด์ญ์ ๋ณด์ฌ์ฃผ๋ ์ต๊ทค๋ฌ ์ปดํฌ๋ํธ
import { Component, OnInit, Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {HttpClient} from '@angular/common/http';

@Component({
    selector: 'recent-tacos',
    templateUrl: 'recents.component.html',
    styleUrls: ['./recents.component.css']
})

@Injectable()
export class RecentTacosComponent implements OnInit{
    recentTacos: any;

    constructor(private httpClient: HttpClient){}

    ngOnInit(){
        //์ต๊ทผ ์์ฑ๋ ํ์ฝ๋ค์ ์๋ฒ์์ ๊ฐ์ ธ์จ๋ค
        this.httpClient.get('http://localhost/design/recent')
        .subscribe(data => this.recentTacos = data);
    }
}

```

ngOnInit()๋ฉ์๋์ ์ฃผ๋ชฉํ์. ์ด ๋ฉ์๋์์ RecentTacosComponent๋ ์ฃผ์๋ Http๋ชจ๋์ ์ฌ์ฉํด HTTP์์ฒญ์ ์ํํ๋ค

์ด๊ฒฝ์ฐ recentTacos ๋ชจ๋ธ ๋ณ์๋ก ์ฐธ์กฐ๋๋ ํ์ฝ๋ค์ ๋ด์ญ์ด ์๋ต์ ํฌํจ๋๋ค. 

ํ์ฝ ๋์์ธ API์์ฒญ์ ์ฒ๋ฆฌํ๋ REST ์ฌ์ฉ ์ปจํธ๋กค๋ฌ
```
@RestController
@RequestMapping(path="design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {
	
	private TacoRepository tacoRepo;
	
	@Autowired
	EntityLinks entityLinks;
	
	public DesignTacoController(TacoRepository tacoRepo) {
		this.tacoRepo=tacoRepo;
	}
	
	@GetMapping("/recent")
	public Iterable<Taco> recentTacos(){
		PageRequest page=PageRequest.of(0, 12,Sort.by("createdAt").descending());
		
		return tacoRepo.findAll(page).getContent();
	}
}
```

๋จผ์  ์ฑ์๋ ์๋ต๋๊ฒ ๋๋ฌด ๋ง์๋ฐ ์ด๋ฅผ ์ถ๊ฐํด์ผํ๋ค
```
    <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-hateoas</artifactId>
	</dependency>
```

`@RestContoller` ์ ๋ธํ์ด์์ ๋ค์ ๋๊ฐ์ง๋ฅผ ์ง์ํ๋ค. ์ฐ์ , @Controller๋ @Service์ ๊ฐ์ด ์คํ๋ ์ค ํ์

์ ๋ธํ์ด์์ด๋ฏ๋ก ์ด ์ ๋ธํ์ด์์ด ์ง์ ๋ ํด๋์ค๋ฅผ ์ปดํฌ๋ํธ ๊ฒ์์ผ๋ก ์ฐพ์ ์ ์๋ค.

์ฆ `@RestController` ์ ๋ธํ์ด์์ ์ปจํธ๋กค๋ฌ์ ๋ชจ๋  HTTP์์ฒญ ์ฒ๋ฆฌ ๋ฉ์๋์์ HTTP์๋ต ๋ชธ์ฒด์ ์ง์  ์ฐ๋

๊ฐ์ ๋ฐํํ๋ค๋ ๊ฒ์ ์คํ๋ง์๊ฒ ์๋ ค์ค๋ค. ๋ฐ๋ผ์ ๋ฐํ๊ฐ์ด ๋ทฐ๋ฅผ ํตํด HTML๋ก ๋ณํ๋์ง์๊ณ  ์ง์  HTTP์๋ต์ผ๋ก ๋ธ๋ผ์ฐ์ ์ ์ ๋ฌ๋์ด ๋ํ๋๋ค.

๋๋ ์ผ๋ฐ์ ์ธ ์คํ๋ง MVC ์ปจํธ๋กค๋ฌ์ฒ๋ผ ํด๋์ค์ @Controller๋ฅผ ์ฌ์ฉํ  ์๋์๋ค. ๊ทธ๋ฌ๋ ์ด๋๋

์ด ํด๋์ค์ ๋ชจ๋  ์์ฒญ ์ฒ๋ฆฌ ๋ฉ์๋์ @ResponseBody์ ๋ธํ์ด์์ ์ง์ ํด์ผ๋ง @RestController์ ๊ฐ์ ๊ฒฐ๊ณผ๋ฅผ ์ป์์์๋ค.

์ด์ธ์๋ ResponseEntity๊ฐ์ฒด๋ฅผ ๋ฐํํ๋ ๋๋ค๋ฅธ ๋ฐฉ๋ฒ์ด์์ง๋ง ๋ค์์ ์์๋ณด์.

`@RequestMapping`์ ๋ธํ์ด์์๋ produces์์ฑ๋ ์ค์ ๋์ด ์๋ค.  ์ด๊ฒ์ ์์ฒญ์ Acceptํค๋์

"application/json"์ด ํฌํจ๋ ์์ฒญ๋ง์ DesignController์ ๋ฉ์๋์์ ์ฒ๋ฆฌํ๋ค๋ ๊ฒ์ ๋ํ๋ธ๋ค.

์ด๊ฒฝ์ฐ ์๋ต๊ฒฐ๊ณผ๋ JSONํ์์ด ๋์ง๋ง, produces ์์ฑ์ ๊ฐ์ String ๋ฐฐ์ด๋ก ์ ์ฅ๋๋ฏ๋ก ๋ค๋ฅธ ์ปจํธ๋กค๋ฌ์์๋ ์์ฒญ์ 

์ฒ๋ฆฌํ  ์ ์๋๋ก JSON๋ง์ด ์๋ ๋ค๋ฅธ ์ฝํํธ ํ์์ ๊ฐ์ด ์ง์ ํ  ์ ์๋ค.

์๋ฅผ๋ค์ด XML๋ก์ถ๋ ฅํ๊ณ ์ ํ๋ฉด ๋ค์๊ณผ๊ฐ์ด ์ถ๊ฐํ๋ฉด๋๋ค
```
@RequestMapping(path="/design" ,
                produces={"application/json", "text/xml"})
```

๋ํ `@CrossOrign`์ ๋ธํ์ด์์ด ์ง์ ๋์ด ์๋ค.์ต๊ทค๋ฌ ์ฝ๋๋ api์ ๋ณ๋์ ๋๋ฉ์ธ์์ 

์คํ ์ค์ด๋ฏ๋ก ์ต๊ทค๋ฌ ํด๋ผ์ด์ธํธ ์์ api๋ฅผ ์ฌ์ฉ๋ชปํ๊ฒ ์น ๋ธ๋ผ์ฐ์ ๊ฐ ๋ง๋๋ค.  ์ด๋ฐ ์ ์ฝ์ ์๋ฒ ์๋ต์ CORSํค๋๋ฅผ ํฌํจ์์ผ ๊ทน๋ณตํ  ์ ์์ผ๋ฉฐ

์คํ๋ง์์๋ @CrossOrigin์ ๋ธํ์ด์์ ์ง์ ํ์ฌ ์ฝ๊ฒ CORS๋ฅผ ์ ์ฉํ  ์ ์๋ค.

@CrossOrigin์ ๋ค๋ฅธ ๋๋ฉ์ธ์ ํด๋ผ์ด์ธํธ์์ ํด๋น REST API๋ฅผ ์ฌ์ฉํ  ์ ์๊ฒ ํด์ฃผ๋ ์คํ๋ง ์ ๋ธํ์ด์์ด๋ค.


ํ์ฝ ID๋ก ํน์  ํ์ฝ๋ง ๊ฐ์ ธ์ค๋ ์๋ํฌ์ธํธ๋ฅผ ์ ๊ณตํ๊ณ  ์ถ๋ค๋ฉด ์ด๋ป๊ฒํ ๊น? ๋ฉ์๋์ ๊ฒฝ๋ก์ ํ๋ ์ด์คํ๋

๋ณ์๋ฅผ ์ง์ ํ๊ณ  ํด๋น ๋ณ์๋ฅผ ํตํด ID๋ฅผ ์ธ์๋ก ๋ฐ๋ ๋ฉ์๋๋ฅผ ์ถ๊ฐํ๋ฉด๋๋ค.

```
    @GetMapping("/{id}")
	public Taco tacoById(@PathVariable("id") Long id) {
		Optional<Taco> optTaco= tacoRepo.findById(id);
		if(optTaco.isPresent()) {
			return optTaco.get();
		}
		return null;
	}
```
DesignTacoController์ ๊ธฐ๋ณธ๊ฒฝ๋ก๊ฐ /design์ด๋ฏ๋ก ์ด ๋ฉ์๋๋ /design/{id} ๊ฒฝ๋ก์ GET์์ฒญ์ ์ฒ๋ฆฌํ๋ค. 

์ฌ๊ธฐ์ ๊ฒฝ๋ก์ {id}๋ถ๋ถ์ด ํ๋ ์ด์ค ํ๋์ด๋ฉฐ `@PathVariable`์ ์ํด {id}ํ๋ ์ด์คํ๋์ ๋์๋๋

id๋งค๊ฐ๋ณ์์ ํด๋น ์์ฒญ์ ์ค์  ๊ฐ์ด ์ง์ ๋๋ค.

ํ์ง๋ง ์์ ๊ฐ์ ์ฝ๋๋ ์ข์๋ฐฉ๋ฒ์ด ์๋๋ค. null์ ๋ฐํํ๋ฉด ์ปจํ์ธ ๊ฐ ์๋๋ฐ๋ ์ ์์ฒ๋ฆฌ๋ฅผ ๋ํ๋ด๋ 

HTTP 200(OK) ์ํ์ฝ๋๋ฅผ ํด๋ผ์ด์ธํธ๊ฐ ๋ฐ๊ธฐ๋๋ฌธ์ด๋ค.  ๋ฐ๋ผ์ ์ด๋๋ HTTP404(NotFound)์ํ ์ฝ๋๋ฅผ

์๋ต์ผ๋ก ๋ฐํํ๋ ๊ฒ์ด ๋์ข๋ค.

```
    //์ด๋ ๊ฒ ๊ณ ์น์!
	@GetMapping("/{id}")
	public ResponseEntity<Taco> tacoById(@PathVariable("id")Long id){
		Optional<Taco> optTaco=tacoRepo.findById(id);
		if(optTaco.isPresent()) {
			return new ResponseEntity<>(optTaco.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
```

์ด๋ ๊ฒํ๋ฉด Taco ๋์  ResponseEntity< Taco> ๊ฐ ๋ฐํ๋๋ค. ์ด ๊ฒฝ์ฐ ์ฐพ์ ํ์ฝ๊ฐ ์์๋๋ HTTP 200(OK) ์ํ

์ฝ๋๋ฅผ ๊ฐ๋ ResponseEntity์ Taco๊ฐ๊ฒ๊ฐ ํฌํจ๋๋ค. ๊ทธ๋ฌ๋ ์ฐพ์ง ๋ชปํ์๋๋ HTTP 404(NOT FOUND)

์ํ์ฝ๋๋ฅผ ๊ฐ๋ ResponseEntity์ null์ด ํฌํจ๋์ด ํด๋ผ์ด์ธํธ์์ ๊ฐ์ ธ์ค๋ ค๋ ํ์ฝ๊ฐ ์๋ค๋ ๊ฒ์ ๋ํ๋ธ๋ค.

์ด์  ํ์ฝํด๋ผ์ฐ๋ API๋ฅผ ์ฌ์ฉํ  ์ ์๋ค. ๊ทธ๋ฆฌ๊ณ  ๊ฐ๋ฐ์์ API๋ฅผ ํ์คํธํ  ๋๋ curl์ด๋ HTTPPie๋ฅผ ์ฌ์ฉํด๋ ๋๋ค

๋ช๋ นํ์์ curl์ ์ฌ์ฉํด ์ต๊ทผ ์์ฑ๋ ํ์ฝ๋ค์ ๊ฐ์ ธ์ค๋ ์๋ ๋ค์๊ณผ ๊ฐ๋ค
    
    $ curl localhost:8080/design/recent

HTTPPie๋ฅผ ์ฌ์ฉํ ๋๋ ๋ค์๊ณผ ๊ฐ๋ค

    $ http :8080/design/recent

### ๐์๋ฒ์ ๋ฐ์ดํฐ ์ ์กํ๊ธฐ 

์ต๊ทค๋ฌ ์ฝ๋๋ ์๋ตํ๋ค. ํ์ฝ๋์์ธ ๋ฐ์ดํฐ๋ฅผ ์์ฒญํ๊ณ  ์ ์ฅํ๋ ๋ฉ์๋๋ฅผ DesignTacoController์ ์ถ๊ฐํ์.
```
    @PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Taco postTaco(@RequestBody Taco taco) {
		return tacoRepo.save(taco);
	}
```

postTaco()๋ HTTP POST์์ฒญ์ ์ฒ๋ฆฌํ๋ฏ๋ก @GetMapping๋์  @PostMapping์ ๋ธํ์ด์์ ์ง์ ํ์๋ค.

๊ทธ๋ฆฌ๊ณ  path์์ฑ์ ์ง์ ํ์ง ์์์ผ๋ฏ๋ก ํด๋์ค์ ์ง์ ๋ @RequestMapping์ /design ๊ฒฝ๋ก์ ๋ํ ์์ฒญ์ ์ฒ๋ฆฌํ๋ค.

์ฌ๊ธฐ์๋ consumes์์ฑ์ ์ค์ ํ์๋ค. ๋ฐ๋ผ์ Content-type์ด application/json๊ณผ ์ผ์นํ๋ ์์ฒญ๋ง ์ฒ๋ฆฌํ๋ค.

postTaco()๋ฉ์๋์ taco๋งค๊ฐ๋ณ์์๋ `@RequestBody`๊ฐ ์ง์ ๋์๋ค. ์ด๊ฒ์ ์์ฒญ ๋ชธ์ฒด์

JSON๋ฐ์ดํฐ๊ฐ Taco๊ฐ์ฒด๋ก ๋ณํ๋์ด taco ๋งค๊ฐ๋ณ์์ ๋ฐ์ธ๋ฉ๋๋ค๋ ๊ฒ์ ๋ํ๋ธ๋ค.

@RequestBody์ ๋ธํ์ด์์ ์ค์ํ๋ค. ์ด๊ฒ์ด ์ง์ ๋์ง ์์ผ๋ฉด ๋งค๊ฐ๋ณ์๊ฐ ๊ณง๋ฐ๋ก Taco๊ฐ์ฒด์ ๋ฐ์ธ๋ฉ๋๋๊ฒ์ผ๋ก ์คํ๋ง MVC๊ฐ ๊ฐ์ฃผํ๊ธฐ์..

postTaco()๋ฉ์๋์๋ @ResponseStatus(HttpStatus.CREATED) ์ ๋ธํ์ด์๋ ์ง์ ๋์ด ์๋ค.

๋ฐ๋ผ์ ํด๋น ์์ฒญ์ด ์ฑ๊ณต์ ์ด๋ฉด์ ์์ฒญ์ ๊ฒฐ๊ณผ๋ก ๋ฆฌ์์ค๊ฐ ์์ฑ๋๋ฉด HTTP 201(CREATED)์ํ์ฝ๋๊ฐ ํด๋ผ์ด์ธํธ์๊ฒ ์ ๋ฌ๋๋ค. 

์ด๊ฒฝ์ฐ @ResponseStatus๋ฅผ ์ฌ์ฉํ์ง ์์์ ๋ ์์ฒญ ์ฑ๊ณต์ ๋ํ๋ด๋ HTTP 200(OK) ์ํ์ฝ๋๋ณด๋ค 

๋ ์์ธํ ์ค๋ช์ ์๋ ค์ค ์ ์๋ค. ๊ทธ๋ฌ๋ฏ๋ก ํญ์ @ResponseStatus๋ฅผ ์ฌ์ฉํ์ฌ ํด๋ผ์ด์ธํธ์๊ฒ ๋ ์์ ์ ์ด๋ฉฐ ์ ํํ

HTTP์ํ์ฝ๋๋ฅผ ์ ๋ฌํ๋ ๊ฒ์ด ์ข๋ค.

### ๐์๋ฒ์ ๋ฐ์ดํฐ ๋ณ๊ฒฝํ๊ธฐ

๋ฐ์ดํฐ๋ฅผ ๋ณ๊ฒฝํ๊ธฐ ์ํ HTTP๋ฉ์๋๋ก๋ PUT๊ณผ PATCH๊ฐ ์๋ค. ์ ๋๊ฐ๊ฐ ์๋์ง ์ด์ ๋ฅผ ์๊ณ  ์ปจํธ๋กค๋ฌ๋ฅผ ์์ฑํ๋๊ฒ ์ค์ํ๋ค

`PUT`์ ๋ฐ์ดํฐ๋ฅผ ๋ณ๊ฒฝํ๋๋ฐ ์ฌ์ฉ๋๊ธฐ๋ ํ์ง๋ง, ์ค์ ๋ก๋ GET๊ณผ ๋ฐ๋์ ์ด๋ฏธ๋ฅผ ๊ฐ๋๋ค. ์ฆ GET์์ฒญ์

์๋ฒ๋ก๋ถํฐ ํด๋ผ์ด์ธํธ๋ก ๋ฐ์ดํฐ๋ฅผ ์ ์กํ๋ ๋ฐ๋ฉด, `PUT`์์ฒญ์ ํด๋ผ์ด์ธํธ๋ก๋ถํฐ ์๋ฒ๋ก ๋ฐ์ดํฐ๋ฅผ ์ ์กํ๋ค.

์ด๋ฐ ๊ด์ ์์ PUT์ ๋ฐ์ดํฐ ์ ์ฒด๋ฅผ ๊ต์ฒดํ๋ ๊ฒ์ด๋ฉฐ `PATCH`์ ๋ชฉ์ ์ ๋ฐ์ดํฐ์ ์ผ๋ถ๋ถ์ ๋ณ๊ฒฝํ๋ ๊ฒ์ด๋ค.

์๋ฅผ๋ค์ด, ํน์  ์ฃผ๋ฌธ ๋ฐ์ดํฐ์ ์ฃผ์๋ฅผ ๋ณ๊ฒฝํ๊ณ  ์ถ๋ค๊ณ ํ์. REST API๋ฅผ ํตํด์ ์ด๋ ๊ฒ ํ  ์ ์๋ ํ๊ฐ์ง ๋ฐฉ๋ฒ์ PUT์์ฒญ์ํ๋๊ฑฐ๋ค.

```
@PutMapping("/{orderId})
public Order putOrder(@RequestBody Order order){
    return repo.save(order);
}
```

๊ทธ๋ฌ๋ ์ด๊ฒฝ์ฐ๋ ํด๋ผ์ด์ธํธ์์ ํด๋น ์ฃผ๋ฌธ ๋ฐ์ดํฐ ์ ์ฒด๋ฅผ PUT์์ฒญ์ผ๋ก ์ ์ถํด์ผ ํ๋ค. 

PUT์ ํด๋น URL์ ์ด ๋ฐ์ดํฐ๋ฅผ ์ฐ๋ผ๋ ์๋ฏธ์ด๋ฏ๋ก ์ด๋ฏธ ์กด์ฌํ๋ ํด๋น ๋ฐ์ดํฐ ์ ์ฒด๋ฅผ ๊ต์ฒดํ๋ค.

๊ทธ๋ฆฌ๊ณ  ๋ง์ผ ํด๋น ์ฃผ๋ฌธ์ ์์ฑ์ด ์๋ต๋๋ฉด ์์ฑ์ ๊ฐ์ null๋ก ๋ณ๊ฒฝ๋๋ค. 

๊ทธ๋ ๋ค๋ฉด ๋ฐ์ดํฐ์ ์ผ๋ถ๋ง ๋ณ๊ฒฝํ๊ณ ์ํ๋ฉด ์ด๋ป๊ฒ ์์ฒญ์ ์ฒ๋ฆฌํด์ผํ ๊น?

ํน์  ์ฃผ๋ฌธ์ PATCH์์ฒญ์ ์ฒ๋ฆฌํ๋ ์ปจํธ๋กค๋ฌ ๋ฉ์๋๋ ๋ค์๊ณผ ๊ฐ์ด ์์ฑํ  ์ ์๋ค.

```
@PatchMapping(path="/{orderId}", consumes="application/json")
public Order patchOrder(@PathVariable("orderId") Long orderId, @RequestBody Order patch){
    Order order=repo.findById(orderId).get();
    if(patch.getDeliveryName()!=null){
        order.setDeliveryName(patch.getDeliveryName());
    }
    if(patch.getDeliveryStreet()!= null){
        order.setDeliveryStreet(patch.getDeliveryStreet());
    }
    if(patch.getDeliveryCity() != null){
        order.setDeliveryState(patch.getDeliveryState());
    }
    if(patch.getDeliveryZip() != null){
        order.setDeliveryZip(patch.getDeliveryZip()); //์ฑ์ ์คํ์์ด์ ์์ ํจ.
    }
    if(patch.getCcNumber() != null){
        order.setCcNumber(patch.getCcNumber());
    }
    if(patch.getCcExpiration() != null){
        order.setCcExpiration(patch.getCcExpiration());
    }
    if(patch.getCcCVV() != null){
        order.setCcCVV(patch.getCcCVV());
    }
    return repo.save(order);
}


```

putOrder()๋ฉ์๋์ ๊ฒฝ์ฐ HTTP PUT์ ์๋ฏธ๋๋ก ํ ์ฃผ๋ฌธ์ ์ ์ฒด ๋ฐ์ดํฐ๋ฅผ ๋ฐ๊ณ  ์ ์ฅํ๋ค. ๊ทธ๋ฌ๋ HTTP PATCH์ ์๋ฏธ๋ฅผ

๋ฐ๋ฅด๋ patchMapping()์์๋ ๋ฐ์ดํฐ์ ์ผ๋ถ๋ง ๋ณ๊ฒฝํ๊ธฐ ์ํ ๋ก์ง์ด ํ์ํ๋ค.  ์ฆ ํด๋น ์ฃผ๋ฌธ ๋ฐ์ดํฐ๋ฅผ ์ ์ก๋ Order๊ฐ์ฒด๋ก

์์ ํ ๊ต์ฒดํ๋ ๋์ , Order๊ฐ์ฒด์ ๊ฐ ํ๋ ๊ฐ์ด null์ด ์๋์ง ํ์ธํ๊ณ  ๊ธฐ์กด ์ฃผ๋ฌธ ๋ฐ์ดํฐ์ ๋ณ๊ฒฝํด์ผํ๋ค.

์ด๋ฐฉ๋ฒ์ ์ฌ์ฉํ๋ฉด ํด๋ผ์ด์ธํธ์์ ๋ณ๊ฒฝํ  ์์ฑ๋ง ์ ์กํ๋ฉด ๋๋ค. ๊ทธ๋ฆฌ๊ณ  ์๋ฒ์์๋ ํด๋ผ์ด์ธํธ์์ ์ง์ ํ์ง ์์ ์์ฑ์ ๊ธฐ์กด๋ฐ์ดํฐ๋ฅผ ๋ณด๊ดํ ์์๋ค.

### ๐์๋ฒ์์ ๋ฐ์ดํฐ ์ญ์ ํ๊ธฐ 

๋ฐ์ดํฐ๋ฅผ ๊ทธ๋ฅ ์ญ์ ํ  ๋๋ ํด๋ผ์ด์ธํธ์์ HTTP DELETE ์์ฒญ์ผ๋ก ์ญ์ ๋ฅผ ์์ฒญํ๋ฉด ๋๋ค. ์ด๋๋ DELETE ์์ฒญ์ ์ฒ๋ฆฌํ๋ ๋ฉ์๋์

์คํ๋ง MVC์ @DeleteMapping์ ์ง์ ํ๋ค. ์๋ฅผ๋ค์ด, ์ฃผ๋ฌธ ๋ฐ์ดํฐ๋ฅผ ์ญ์ ํ๋ API์ ์ปจํธ๋กค๋ฌ ๋ฉ์๋๋ ๋ค์๊ณผ ๊ฐ๋ค

```
@DeleteMapping("/orderId}")
@ResponseStatus(code=HttpStatus.NO_CONTENT)
public void deleteOrder(@PathVariable("orderId") Long orderId){
    try{
        repo.deleteById(orderId);
    }catch(EmptyResultDataAccessException e){}
}
```

deleteOrder()๋ฉ์๋์ ์ฝ๋๊ฐ ํ๋์ผ์ ํน์  ์ฃผ๋ฌธ ๋ฐ์ดํฐ๋ฅผ ์ญ์ ํ๋ ๊ฒ์ด๋ค. ์ด๋ URL์ ๊ฒฝ๋ก ๋ณ์๋ก ์ ๊ณต๋ ์ฃผ๋ฌธ ID๋ฅผ ์ธ์๋ก

๋ฐ์์ ๋ ํฌ์งํ ๋ฆฌ์ deleteBhyId()๋ฉ์๋์ ์ ๋ฌํ๋ค. ๊ทธ๋ฆฌ๊ณ  ์ด ๋ฉ์๋๊ฐ ์คํ๋  ๋ ํด๋น ์ฃผ๋ฌธ์ด ์กด์ฌํ๋ฉด ์ญ์ ๋๋ฉฐ ์์ผ๋ฉด

EmptyResultDataAccessException์ด ๋ฐ์๋๋ค.

์ด์ธ์ deleteOrder()๋ฉ์๋์๋ @ResponseStatus๊ฐ ์ง์ ๋์ด ์๋ค. ์ด๊ฒ์ ์๋ต์ HTTP ์ํ์ฝ๋๊ฐ 204(NO CONNECT)๊ฐ ๋๋๋ก

ํ๊ธฐ์ํด์์ด๋ค. ์ด ๋ฉ์๋๋ ์ฃผ๋ฌธ ๋ฐ์ดํฐ๋ฅผ ์ญ์ ํ๋ ๊ฒ์ด๋ฏ๋ก ํด๋ผ์ด์ธํธ์๊ฒ ๋ฐ์ดํฐ๋ฅผ ๋ฐํํ  ํ์๊ฐ์๋ค.

๋ฐ๋ผ์ ๋๊ฐ์ ๊ฒฝ์ฐ DELETE์์ฒญ์ ์๋ต์ ๋ชธ์ฒด ๋ฐ์ดํฐ๋ฅผ ๊ฐ์ง ์์ผ๋ฉฐ, ๋ฐํ ๋ฐ์ดํฐ๊ฐ ์๋ค๋ ๊ฒ์ ํด๋ผ์ด์ธํธ๊ฐ ์ ์ ์๊ฒ HTTP์ํ ์ฝ๋๋ฅผ ์ฌ์ฉํ๋ค.

## ๐ํ์ดํผ๋ฏธ๋์ด ์ฌ์ฉํ๊ธฐ

API ํด๋ผ์ด์ธํธ ์ฝ๋์์๋ ํํ ํ๋์ฝ๋ฉ๋ URLํจํด์ ์ฌ์ฉํ๊ณ  ๋ฌธ์์ด๋ก ์ฒ๋ฆฌํ๋ค. ๊ทธ๋ฌ๋ API์ URL์คํด์ด ๋ณ๊ฒฝ๋๋ฉด ์ด๋ป๊ฒ๋ ๊น?

ํ๋์ฝ๋ฉ๋ ํด๋ผ์ด์ธํธ ์ฝ๋๋ API๋ฅผ ์๋ชป์ธ์ํ์ฌ ์ ์์ ์ผ๋ก ์คํ๋์ง ์์ ๊ฒ์ด๋ค. ๋ฐ๋ผ์ API UTL์ ํ๋์ฝ๋ฉํ๊ณ  

๋ฌธ์์ด๋ก ์ฒ๋ฆฌํ๋ฉด ํด๋ผ์ด์ธํธ ์ฝ๋๊ฐ ๋ถ์์ ํด์ง๋ค.

REST API๋ฅผ ๊ตฌํํ๋ ๋ ๋ค๋ฅธ ๋ฐฉ๋ฒ์ผ๋ก HATEOAS๊ฐ ์๋ค. ์ด๊ฒ์ API๋ก๋ถํฐ ๋ฐํ๋๋ ๋ฆฌ์์ค์ ํด๋น ๋ฆฌ์์ค์ ๊ด๋ จ๋ ํ์ดํผ๋งํฌ๋ค์ด ํฌํจ๋๋ค.

๋ฐ๋ผ์ ํด๋ผ์ด์ธํธ๊ฐ ์ต์ํ์ API URL๋ง ์๋ฉด ๋ฐํ๋๋ ๋ฆฌ์์ค์ ๊ด๋ จํ์ฌ ์ฒ๋ฆฌ ๊ฐ๋ฅํ ๋ค๋ฅธ API URL๋ค์ ์์๋ด์ด ์ฌ์ฉํ  ์ ์๋ค.

์๋ฅผ๋ค์ด, ํ์ดํผ๋งํฌ๊ฐ ์๋ ํํ์ ์ต๊ทผ ํ์ฝ ๋ฆฌ์คํธ๋ ๋ค์๊ณผ ๊ฐ์ด JSONํ์์ผ๋ก ํด๋ผ์ด์ธํธ์์ ์์ ๋ ๊ฒ์ด๋ค
```
[
    {
        "id":4,
        "name: "Veg-Out",
        "createdAt": "2021-02-14T20:15:53.219+0000",
        "ingredients":[
            {"id":"FLTO", "name": "Flour Tortilla" , "type" : "WRAP"}
            ...
        ]
    },
    ...
]
```

์ด ๊ฒฝ์ฐ ๋ง์ผ ํด๋ผ์ด์ธํธ๊ฐ ํ์ฝ ์์ฒด์ ๋ํ ๋ค๋ฅธ HTTP์์์ ์ํํ๊ณ  ์ถ๋ค๋ฉด /design๊ฒฝ๋ก์ URL์ id์์ฑ๊ฐ์ 

์ถ๊ฐํด์ผ ํ๋ค๋๊ฒ์ ์๊ณ  ์์ด์ผ ํ๋ค. ๋ง์ฐฌ๊ฐ์ง๋ก ์์์ฌ ์ค ํ๋์ HTTP์์์ ์ํํ๊ณ  ์ถ๋ค๋ฉด /ingredients๊ฒฝ๋ก์ URL์

ํด๋น ์์์ฌ์ id์์ฑ ๊ฐ์ ์ถ๊ฐํด์ผ ํ๋ค๋ ๊ฒ์ ์์์ผํ๋ค. ๊ทธ๋ฆฌ๊ณ  ์ด๋ค ๊ฒฝ์ฐ๋  ํด๋น ๊ฒฝ๋ก ์์ http://๋ https:// ๋ฐ APIํธ์คํธ์ด๋ฆ๋ ๋ถ์ฌ์ผํ๋ค.

์ด์๋ ๋ค๋ฅด๊ฒ API์ ํ์ดํผ๋ฏธ๋์ด๊ฐ ํ์ฑํ ๋๋ฉด API์๋ ์์ ๊ณผ ๊ด๋ จ๋ URL์ด ๋ํ๋๋ฏ๋ก ๊ทธ๊ฒ์ ํด๋ผ์ด์ธํธ๊ฐ ํ๋์ฝ๋ฉํ์ง ์์๋ ๋๋ค.
```
{
    "_embedded":{
        "tacoResourceList":[
            {
                "name":"Veg-Our",
                "createdAt":"2021-02-14T20:15:53.219+0000",
                "ingredients":[
                    {
                    "name":"Flour Tortilla", "type":"WRAP",
                    "_links":{
                        "self": { "href" : "http://localhost:8080/ingredients/FLTO"}
                        }
                    },
                    ...
                ]
            }
        ]
    },
    "_links":{
        "recents":{
            "href":"http://localhost:8080/design/recent"
        }
    }
}
```
์ด๋ฐ ํํ์ HATEOAS๋ฅผ HAL์ด๋ผ๊ณ ํ๋ค. ์ด๊ฒ์ JSON์๋ต์ ํ์ดํผ๋งํฌ๋ฅผ ํฌํจ์ํฌ๋ ์ฃผ๋ก ์ฌ์ฉ๋๋ ํ์์ด๋ค.

์ด ํ์ฝ ๋ฆฌ์คํธ์ ๊ฐ์์๋ _links๋ผ๋ ์์ฑ์ ํฌํจํ๋๋ฐ ์ด์์ฑ์ ํด๋ผ์ด์ธํธ๊ฐ ๊ด๋ จ API๋ฅผ ์ํํ ์์๋ ํ์ดํผ๋งํฌ๋ฅผ ํฌํจํ๋ค.

ํ์ฝ์ ํด๋นํ์ฝ์ ์์์ฌ ๋ชจ๋ ๊ทธ๋ค ๋ฆฌ์์ค๋ฅผ ์ฐธ์กฐํ๋ self๋งํฌ๋ฅผ ๊ฐ์ง๋ฉฐ, ๋ฆฌ์คํธ ์ ์ฒด๋ ์์ ์ ์ฐธ์กฐํ๋ recents๋งํฌ๋ฅผ๊ฐ๋๋ค

๋ฐ๋ผ์ ํด๋ผ์ด์ธํธ ์ ํ๋ฆฌ์ผ์ด์์ด ํ์ฝ๋ฆฌ์คํธ์ ํน์  ํ์ฝ์ ๋ํด HTTP์์ฒญ์ ์ํํด์ผํ ๋ ํด๋น ํ์ฝ ๋ฆฌ์์ค์ URL์ ์ง์ ํ์ง์์๋๋๋ค.

๋์ ์ ์ฐธ์กฐํ๋ selef๋งํฌ๋ฅผ ์์ฒญํ๊ณ  ํด๋นํ์ฝ์ ํน์  ์์์ฌ๋ฅผ ์ฒ๋ฆฌํ๊ณ ์ ํ  ๋๋ ํด๋น ์์์ฌ์ selef๋งํฌ๋ง ์ ์ํ๋ฉด๋๋ค.

์คํ๋ง HATEOASํ๋ก์ ํธ๋ ํ์ดํผ๋งํฌ๋ฅผ ์คํ๋ง์ ์ง์ํ๋ค. ๊ตฌ์ฒด์ ์ผ๋ก ๋งํด์ ์คํ๋ง MVC์ปจํธ๋กค๋ฌ์์ ๋ฆฌ์์ค๋ฅผ ๋ฐํํ๊ธฐ ์ ์

ํด๋น ๋ฆฌ์์ค์ ๋งํฌ๋ฅผ ์ถ๊ฐํ๋๋ฐ ์ฌ์ฉํ  ์ ์๋ ํด๋์ค์ ๋ฆฌ์์ค ์ด์๋ธ๋ฌ๋ฅผ ์ ๊ณตํ๋ค.

### ๐ํ์ดํผ๋งํฌ ์ถ๊ฐํ๊ธฐ

`์คํ๋ง HATEOAS`๋ ํ์ดํผ๋งํฌ ๋ฆฌ์์ค๋ฅผ ๋ํ๋ด๋ ๋ ๊ฐ์ ๊ธฐ๋ณธํ์์ธ `Resource`์ `Resources`๋ฅผ ์ ๊ณตํ๋ค.

Resource ํ์์ ๋จ์ผ ๋ฆฌ์์ค๋ฅผ, ๊ทธ๋ฆฌ๊ณ  Resources๋ ๋ฆฌ์์ค ์ปฌ๋ ์์ ๋ํ๋ด๋ฉฐ, ๋ ํ์ ๋ชจ๋ ๋ค๋ฅธ ๋ฆฌ์์ค๋ฅผ ๋งํฌํ  ์ ์๋ค.

๋ ํ์์ด ์ ๋ฌํ๋ ๋งํฌ๋ ์คํ๋ง MVC์ปจํธ๋กค๋ฌ ๋ฉ์๋์์ ๋ฐํ๋  ๋ ํด๋ผ์ด์ธํธ๊ฐ ๋ฐ๋ JSON์ํฌํจ๋๋ค.

์ต๊ทผ ์์ฑ๋ ํ์ฝ ๋ฆฌ์คํธ์ ํ์ดํผ๋งํฌ๋ฅผ ์ถ๊ฐํ๋ ค๋ฉด recentTacos()๋ฉ์๋์์ List< Taco>๋ฅผ ๋ฐํํ๋ ๋์  CollectionModel๊ฐ์ฒด๋ฅผ ๋ฐํํ๋๋ก ์์ ํด์ผํ๋ค.

```
    @GetMapping("/recent")
	public CollectionModel<EntityModel<Taco>> recentTacos(){
		PageRequest page=PageRequest.of(0, 12,Sort.by("createdAt").descending());
		
		List<Taco> tacos=tacoRepo.findAll(page).getContent();
		CollectionModel<EntityModel<Taco>> recentResources=CollectionModel.wrap(tacos);
		
		recentResources.add(new Link("http://localhost:8080/design/recent","recents"));
		return recentResources;
	}
```

์ด๋ ๊ฒ ์์ ๋ recentTacos()์์๋ ์ง์  ํ์ฝ๋ฆฌ์คํธ๋ฅผ ๋ฐํํ์ง ์๊ณ  ๋์  CollectionModel.wrap()์ ์ฌ์ฉํด์

recnetTacos()์ ๋ฐํํ์์ธ CollectionModel< EntityModel < Taco>>์ ์ธ์คํด์ค๋ก ํ์ฝ ๋ฆฌ์คํธ๋ฅผ ๋งคํํ๋ค.

๊ทธ๋ฌ๋ CollectionModel ๊ฐ์ฒด๋ฅผ ๋ฐํํ๊ธฐ ์ ์ ์ด๋ฆ์ด recents์ด๊ณ  URL์ด http://localhost:8080/design/recent์ธ ๋งํฌ๋ฅผ ์ถ๊ฐํ๋ค.

๋ฐ๋ผ์ API์์ฒญ์์ ๋ฐํ๋๋ ๋ฆฌ์์ค์ ๋ค์์ JSON์ฝ๋๊ฐ ํฌํจ๋๋ค

```
"_links":{
    "recents":{
        "href":"http://localhost:8080/design/recent"
    }
}
```

ํ์ง๋ง ์ด๊ฒ๋ํ URL์ ํ๋์ฝ๋ฉํ๋๊ฒ์ผ๋ก ์ข์๋ฐฉ๋ฒ์ ์๋๋ค. ํ์ฝํด๋ผ์ฐ๋ ์ ํ๋ฆฌ์ผ์ด์์ ๊ฐ๋ฐ์ฉ ์ปดํจํฐ์์๋ง ์คํ๋๋ค๋ฉด

๋ชจ๋ฅผ๊น ๋ก์ปฌํธ์คํธ์ ํฌํธ๋ฅผ ๋ํ๋ด๋ localhost:8080์ผ๋ก URL์ ํ๋์ฝ๋ฉํ๋ฉด ์๋๊ธฐ ๋๋ฌธ์ด๋ค. ๋คํํ๊ฒ๋์คํ๋ง HATEOAS๋

๋งํฌ ๋น๋๋ฅผ ์ ๊ณตํ์ฌ URL์ ํ๋์ฝ๋ฉํ์ง ์๋ ๋ฐฉ๋ฒ์ ์ ๊ณตํ๋ค

์คํ๋ง HATEOAS๋งํฌ ๋น๋ ์ค ๊ฐ์ฅ ์ ์ฉํ ๊ฒ์ด `ControllerLinkBuilder`๋ค. ์ด ๋งํฌ๋น๋๋ฅผ ์ฌ์ฉํ๋ฉด URL์

ํ๋์ฝ๋ฉํ์ง ์๊ณ  ํธ์คํธ ์ด๋ฆ์ ์ ์ ์๋ค. ๊ทธ๋ฆฌ๊ณ  ์ปจํธ๋กค๋ฌ์ ๊ธฐ๋ณธ URL์ ๊ด๋ จ๋ ๋งํฌ์ ๋น๋๋ฅผ ๋์์ฃผ๋ ํธ๋ฆฌํ API๋ฅผ ์ ๊ณตํ๋ค

`WebMvcLinkBuilder`๋ฅผ ์ฌ์ฉํ๋ฉด recentTacos()์ ํ๋ ์ฝ๋ฉ๋ Link๋ฅผ ๋ค์๊ณผ ๊ฐ์ด ์์ฑํ  ์ ์๋ค.
```
recentResources.add(WebMvcLinkBuilder.linkTo(DesignTacoController.class)
			.slash("recent")
			.withRel("recents")
			);
```

์ด์ ๋ ํธ์คํธ ์ด๋ฆ์ ํ๋์ฝ๋ฉํ  ํ์๊ฐ ์์ผ๋ฉฐ, /design ๊ฒฝ๋ก ์ญ์ ์ง์ ํ์ง ์์๋ ๋๋ค.

๋์ ์ ๊ธฐ๋ณธ๊ฒฝ๋ก๊ฐ /design์ธ ๋งํฌ๋ฅผ DesignTacoController์ ์์ฒญํ๋ค. WebMvcLinkBuilder๋ ์ด ์ปจํธ๋กค๋ฌ์

๊ธฐ๋ณธ ๊ฒฝ๋ก๋ฅผ ์ฌ์ฉํด์ Link๊ฐ์ฒด๋ฅผ ์์ฑํ๋ค. ๊ทธ ๋ค์์๋ ์คํ๋ง ํ๋ก์ ํธ์์ ๋ง์ด ์ฌ์ฉํ๋ slash()๋ฉ์๋๋ฅผ ํธ์ถํ๋ค.

์ด ๋ฉ์๋๋ ์ด๋ฆ ๊ทธ๋๋ก ์ฌ๋์(/)์ ์ธ์๋ก ์ ๋ฌ๋ ๊ฐ์ URL์ ์ถ๊ฐํ๋ค. ๋ฐ๋ผ์ URL์ ๊ฒฝ๋ก๋ /design/recent๊ฐ๋๋ค.

์ ์ผ ๋์๋ ํด๋น Link์ ๊ด๊ณ ์ด๋ฆ์ ์ง์ ํ๋ฉฐ, ์ด ์์์๋ recents๋ค.

๋ํ WebMvcLinkBuilder์๋ ๋งํฌ URL์ ํ๋์ฝ๋ฉํ์ง ์๊ฒ ํด์ฃผ๋ ๋ ๋ค๋ฅธ ๋ฉ์๋์ธ `linkTo()`๊ฐ ์์ด์ slash()๋์  ํธ์ถํ ์๋์๋ค.

```
	recentResources.add(
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DesignTacoController.class).recentTacos())
			.withRel("recents")
			);
```

`methodOn()`์ปจํธ๋กค๋ฌ ํด๋์ค์ธ DesignTacoController๋ฅผ ์ธ์๋ก ๋ฐ์ recentTacos()๋ฉ์๋๋ฅผ ํธ์ถํ  ์ ์๊ฒํด์ค๋ค.

๋ฐ๋ผ์ ํด๋น ์ปจํธ๋กค๋ฌ์ ๊ธฐ๋ณธ ๊ฒฝ๋ก์ recentTacos()์ ๋งคํ ๊ฒฝ๋ก ๋ชจ๋๋ฅผ ๊ฒฐ์ ํ๋๋ฐ ์ฌ์ฉํ๋ค. ์ด์  URL์๋ชจ๋ ๊ฐ์์ป์ด ํ๋์ฝ๋ฉํ์ง์์๋๋๋ค.

### ๐๋ฆฌ์์ค ์ด์๋ธ๋ฌ ์ฌ์ฉํ๊ธฐ

์ด์  ๋ฆฌ์คํธ์ ํฌํจ๋ ๊ฐ ํ์ฝ ๋ฆฌ์์ค์ ๋ํ ๋งํฌ๋ฅผ ์ถ๊ฐํด์ผํ๋ค. ์ด๋ ํ๊ฐ์ง ๋ฐฉ๋ฒ์ ๋ฐ๋ณต๋ฃจํ์์ Resources๊ฐ์ฒด๊ฐ ๊ฐ์ง๋ ๊ฐ

EntityModel< Taco> ์์์ link๋ฅผ ์ถ๊ฐํ๋ ๊ฒ์ด๋ค. ๊ทธ๋ฌ๋ ์ด๊ฒฝ์ฐ๋ ํ์ฝ๋ฆฌ์์ค์ ๋ฆฌ์คํธ๋ฅผ ๋ฐํํ๋ API์ฝ๋๋ง๋ค ๋ฃจํ๋ฅผ ์คํํ๋ ์ฝ๋๊ฐ 

์์ด์ผํ๋ฏ๋ก ๋ฒ๊ฑฐ๋ก์ ๋ค๋ฅธ ์ ๋ต์ดํ์ํ๋ค.

CollectionModel.wrap()์์ ๋ฆฌ์คํธ์ ๊ฐ ํ์ฝ๋ฅผ EntityModel๊ฐ์ฒด๋ก ์์ฑํ๋๋์  Taco ๊ฐ์ฒด๋ฅผ ์๋ก์ด TacoResource๊ฐ์ฒด๋ก ๋ณํํ๋ ์ ํธ๋ฆฌํฐ ํด๋์ค๋ฅผ ์ ์ํ์
```
public class TacoResource extends RepresentationModel<TacoResource>{
	
	@Getter
	private final String name;
	
	@Getter
	private final Date createdAt;
	
	@Getter
	private final List<Ingredient> ingredients;
	
	public TacoResource(Taco taco) {
		this.name=taco.getName();
		this.createdAt=taco.getCreatedAt();
		this.ingredients=taco.getIngredients();
	}
}
```

TacoResource๋ Taco๊ฐ์ฒด๋ฅผ ์ธ์๋ก ๋ฐ๋ ํ๋์ ์์ฑ์๋ฅผ ๊ฐ์ง๋ฉฐ, Taco๊ฐ์ฒด์ ์์ฑ ๊ฐ์ ์์ ์ ์์ฑ์ ๋ณต์ฌํ๋ค.

๋ฐ๋ผ์ Taco๊ฐ์ฒด๋ฅผ TacoResource๊ฐ์ฒด๋ก ์ฝ๊ฒ ๋ณํํ๋ค. ๊ทธ๋ฌ๋ ์ฌ๊ธฐ๊น์ง๋ง ํ๋ค๋ฉด Taco๊ฐ์ฒด๋ค์ CollectionModel< TacoResource>

๋ก ๋ณํํ๊ธฐ ์ํด ์ฌ์ ํ ๋ฐ๋ณต๋ฃจํ๊ฐ ํ์ํ  ๊ฒ์ด๋ค. ๋ฐ๋ผ์ ๋ฆฌ์คํธ์ Taco๊ฐ์ฒด๋ค์ TacoResource๊ฐ์ฒด๋ค๋ก ๋ณํํ๋๋ฐ ๋์์ ์ฃผ๊ธฐ์ํด ๋ค์์์งํํ๋ค
```
public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource>{

	public TacoResourceAssembler() {
		super(DesignTacoController.class, TacoResource.class);
	}
	
	@Override
	protected TacoResource instantiateModel(Taco entity) {
		return new TacoResource(entity);
	}
	
	@Override
	public TacoResource toModel(Taco entity) {
		return createModelWithId(entity.getId(), entity);
	}

}
```

TacoResourceAssembler์ ๊ธฐ๋ณธ์์ฑ์์์๋ ์ํผํด๋์ค์ธ `RepresentationModelAssemblerSupport`์ ๊ธฐ๋ณธ ์์ฑ์๋ฅผ ํธ์ถํ๋ฉฐ,

์ด๋ TacoResource๋ฅผ ์์ฑํ๋ฉด์ ๋ง๋ค์ด์ง๋ ๋งํฌ์ ํฌํจ๋๋URL์ ๊ธฐ๋ณธ๊ฒฝ๋ก๋ฅผ ๊ฒฐ์ ํ๊ธฐ์ํด DesignTacoController๋ฅผ ์ฌ์ฉํ๋ค

`instantiateModel()`๋ฉ์๋๋ ์ธ์๋ก ์ ๋ฌ๋ Taco๊ฐ์ฒด๋ก TacoResource์ธ์คํด์ค๋ฅผ ์์ฑํ๋๋ก ์ค๋ฒ๋ผ์ด๋ ๋์๋ค. 

TacoResource๊ฐ ๊ธฐ๋ณธ ์์ฑ์๋ฅผ ๊ฐ๊ณ ์๋ค๋ฉด ์ด ๋ฉ์๋๋ ์๋ตํ ์์๋ค. ๊ทธ๋ฌ๋ ์ฌ๊ธฐ์๋ Taco๊ฐ์ฒด๋ก TacoResource์ธ์คํด์ค๋ฅผ 

์์ฑํด์ผํ๋ฏ๋ก ์ค๋ฒ๋ผ์ด๋ ํด์ผํ๋ค.

๋ง์ง๋ง์ผ๋ก `toModel()`๋ฉ์๋๋ RepresentationModelAssemblerSupport๋ก๋ถํฐ ์์๋ฐ์๋ ๋ฐ๋์ ์ค๋ฒ๋ผ์ด๋ ํด์ผํ๋ค.

์ฌ๊ธฐ์๋ Taco๊ฐ์ฒด๋ก TacoResource์ธ์คํด์ค๋ฅผ ์์ฑํ๋ฉด์ Taco๊ฐ์ฒด์ id๊ฐ์ผ๋ก ์์ฑ๋๋ self๋งํฌ๊ฐ URL๋ก ์๋์ง์ ๋๋ค.

์ธ๊ฒฌ์์ผ๋ก๋ toModel()์ด instantiateModel()์ ๊ฐ์ ๋ชฉ์ ์ ๊ฐ๋๊ฒ์ฒ๋ผ ๋ณด์ด์ง๋ง ์ฝ๊ฐ๋ค๋ฅด๋ค. 

instantiantModel()์ EntityModel์ธ์คํด์ค๋ง ์์ฑํ์ง๋ง toModel()์ EntityModel์ธ์คํด์ค๋ฅผ ์์ฑํ๋ฉด์ ๋งํฌ๋ ์ถ๊ฐํ๋ค.

```
public class TacoResources extends CollectionModel<TacoResource>{
	public TacoResources(List<TacoResource> tacoResources) {
		super(tacoResources);
	}
}

```
์ด์  recentTacos()๋ฉ์๋๋ฅผ ๋ณ๊ฒฝํ ์์๋ค.
```
@GetMapping("/recent")
	public CollectionModel<EntityModel<Taco>> recentTacos(){
		PageRequest page=PageRequest.of(0, 12,Sort.by("createdAt").descending());
		
		List<Taco> tacos=tacoRepo.findAll(page).getContent();
		
		List<TacoResource> tacoResources= new TacoResourceAssembler().toResources(tacos);
		CollectionModel<TacoResource> recentResources= new CollectionModel<TacoResource>(tacoResources);
	recentResources.add(
			WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DesignTacoController.class).recentTacos())
			.withRel("recents")
			);
	}
```

recentTacos()์์ ์๋ก์ด TacoResourceํ์์ ์ฌ์ฉํด CollectionModel< EntityModel< Taco>> ๋์ 

CollectionModel< TacoResource>๋ฅผ ๋ฐํํ๋ค. ์ฆ ๋ ํฌ์งํ ๋ฆฌ๋ก๋ถํฐ ํ์ฝ๋ค์ ๊ฐ์ ธ์์ Taco๊ฐ์ฒด ๋ฆฌ์คํธ์ ์ ์ฅํ ํ ๋ฆฌ์คํธ๋ฅผ TacoResourceAssembler์ toResources()๋ฉ์๋์ ์ ๋ฌํ๋ค.

์ด์  ์์์ฌ์ ๋ฆฌ์์ค ์ด์๋ธ๋ฌ ํด๋์ค๋ ๋ง๋ค์ด์ผํ๋ค
```
public class IngredientResource extends RepresentationModel {
    
    @Getter
    private String name;
    
    @Getter
    private Type type;
    
    public IngredientResource(Ingredient ingredient){
        this.name=ingredient.getName();
        this.type=ingredient.getType();
    }
}
```


```
public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource>{

    public IngredientResourceAssembler() {
        super(null/*IngredientController.class* ๊นํ๋ธ๋ณด๋ 13์ฅ์์ ์์ฑํ๋๋ฏ*/, IngredientResource.class);
    }   
    @Override
    public IngredientResource toModel(Ingredient entity) {
        return createModelWithId(entity.getId(),entity);
    }

    @Override
    protected IngredientResource instantiateModel(Ingredient entity) {
        return new IngredientResource(entity);
    }
    ...
    public CollectionModel<IngredientResource> toCollectionModel(Iterable<? extends Ingredient> entities) {
        return super.toCollectionModel(entities);
    }
}
```

## ๐p.s. 
tocollectionModel  ์ฆ ์ฑ์์์ toResources์ ๊ดํด์๋ ์ฑ์๋ ๋ฌผ๋ก  ์ด์ฑ์ ํ์์ ๊นํ๋ธ์๋ ์ด๋ ํ ์๋ฃ๋ ์๋ค.
์ด๋ป๊ฒ ์ฌ์ฉํ๋์ง ์๋ฌธ์ธ ์ํฉ..  

์ผ๋จ ๊ณต๋ถ๋ฅผ์ํด TacoResources์ List๋ฅผ CollectionModel๋ก ๋ณ๊ฒฝ์ ์์ผ๋์๋ค. ์ต์ ๋ฒ์ ์๋ ์ด๋ ๊ฒ ํด์ผํ๋ค!! 


### ๐embedded๊ด๊ณ ์ด๋ฆ ์ง๊ธฐ
```
{
    "_embedded":{
        "tacoResourceList":[
            ...
        ]
    }
}
```

์ฌ๊ธฐ์ embedded๋ฐ์ tacoResourceList๋ผ๋ ์ด๋ฆ์ ์ฃผ๋ชฉํ์.  ์ด ์ด๋ฆ์ Resources๊ฐ์ฒด๊ฐ List< TacoResource>๋ก๋ถํฐ

์์ฑ๋์๋ค๋ ๊ฒ์ ๋ํ๋ธ๋ค. ๋ง์ผ TacoResourceํด๋์ค์ ์ด๋ฆ์ ๋ค๋ฅธ๊ฒ์ผ๋ก ๋ณ๊ฒฝํ๋ค๋ฉด ๊ฒฐ๊ณผ JSONํ๋ ์ด๋ฆ์ด ๊ทธ์ ๋ง์ถฐ์ ๋ฐ๋๊ฒ์ด๋ค. 

๋ฐ๋ผ์ ๋ณ๊ฒฝ ์ ์ ์ด๋ฆ์ ์ฌ์ฉํ๋ ํด๋ผ์ด์ธํธ ์ฝ๋๊ฐ ์ ๋๋ก ์คํ๋์ง ์์๊ฒ์ด๋ค.

์ด๋ด๋ `@Relation`์ ๋ธํ์ด์์ ์ฌ์ฉํ๋ฉด ์๋ฐ๋ก ์ ์๋ ๋ฆฌ์์ค ํ์ ํด๋์ค ์ด๋ฆ๊ณผ JSONํ๋ ์ด๋ฆ๊ฐ์ ๊ฒฐํฉ๋๋ฅผ ๋ฎ์ถ ์ ์๋ค.

์ฆ , ๋ค์๊ณผ ๊ฐ์ด TacoResource์ @Relation์ ์ถ๊ฐํ๋ฉด ์คํ๋ง HATEOAS๊ฐ ๊ฒฐ๊ณผ JSONํ๋ ์ด๋ฆ์ ์ง๋ ๋ฐฉ๋ฒ์ ์ง์ ํ ์์๋ค.

```
@Relation(value="taco", collectionRelation="tacos")
public class TacoResource extends RepresentationModel<TacoResource>{
    ...
}
```

์ฌ๊ธฐ์๋ TacoResource๊ฐ์ฒด ๋ฆฌ์คํธ๊ฐ Resources๊ฐ์ฒด์์ ์ฌ์ฉ๋  ๋ tacos๋ผ๋ ์ด๋ฆ์ด ๋๋๋ก ์ง์ ํ์๋ค. 

JSON์์๋ TacoResource๊ฐ์ฒด๊ฐ taco๋ก ์ฐธ์กฐ๋๋ค.

์ด์๋ฐ๋ผ /design/recent๋ก๋ถํฐ ๋ฐํ๋๋ JSON์ ๋ค์๊ณผ๊ฐ๋ค
```
{
    "_embedded":{
        "tacos":[
            ...
        ]
    }
}
```

์คํ๋ง HATEOAS๋ ์ง๊ด์ ์ด๊ณ  ์ฌ์ด ๋ฐฉ๋ฒ์ผ๋ก API์ ๋งํฌ๋ฅผ ์ถ๊ฐํ์ง๋ง ์ฐ๋ฆฌ๊ฐ ํ์๋ก ํ์ง์๋ ๋ช์ค์ ์ฝ๋๋ฅผ ์๋์ผ๋ก ์ถ๊ฐํ๋ค.

API์ URL์คํด์ด ๋ณ๊ฒฝ๋๋ฉด ํด๋ผ์ด์ธํธ ์ฝ๋ ์คํ์ด ์ค๋จ๋จ์๋ ์๋์ผ๋ก ์ถ๊ฐ๋๋ ์ฝ๋๊ฐ ์ซ์ด์ API์ HATEOAS์ฌ์ฉ์ ๊ณ ๋ คํ์ง ์๋ ๊ฐ๋ฐ์๋ค๋์๊ธดํ๋ค.

๋ง์ผ ์คํ๋ง ๋ฐ์ดํฐ๋ฅผ ๋ ํฌ์งํ ๋ฆฌ๋ก ์ฌ์ฉํ๋ค๋ฉด ๋ ๋ค๋ฅธ๋ฐฉ๋ฒ๋์๋ค.

### ๐๋ฐ์ดํฐ ๊ธฐ๋ฐ ์๋น์ค ํ์ฑํํ๊ธฐ

์คํ๋ง ๋ฐ์ดํฐ๋ ์ฐ๋ฆฌ๊ฐ ์ฝ๋์ ์ ์ํ ์ธํฐํ์ด์ค๋ฅผ ๊ธฐ๋ฐ์ผ๋ก ๋ ํฌ์งํ ๋ฆฌ ๊ตฌํ์ฒด๋ฅผ ์๋์ผ๋ก ์์ฑํ๊ณ  ํ์ํ ๊ธฐ๋ฅ์ ์ํํ๋ค.

๊ทธ๋ฌ๋ ์คํ๋ง ๋ฐ์ดํฐ์๋ ์ ํ๋ฆฌ์ผ์ด์์ API๋ฅผ ์ ์ํ๋๋ฐ ๋์์ ์ค ์ ์๋ ๊ธฐ๋ฅ๋ ์๋ค.

์คํ๋ง ๋ฐ์ดํฐ REST๋ ์คํ๋ง๋ฐ์ดํฐ์ ๋ ๋ค๋ฅธ ๋ชจ๋์ด๋ฉฐ, ์คํ๋ง ๋ฐ์ดํฐ๊ฐ ์์ฑํ๋ ๋ ํฌ์งํ ๋ฆฌ์ REST API๋ฅผ ์๋์์ฑํ๋ค.

๋ฐ๋ผ์ ์คํ๋ง ๋ฐ์ดํฐ REST๋ฅผ ๋น๋์ ์ถ๊ฐํ๋ฉด ์ ์ํ ๊ฐ ๋ ํฌ์งํ ๋ฆฌ ์ธํฐํ์ด์ค๋ฅผ ์ฌ์ฉํ๋ API๋ฅผ ์ป์์์๋ค.
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```

์ด๋ ๊ฒํ๋ฉด ์คํ๋ง๋ฐ์ดํฐ๋ฅผ ์ฌ์ฉ์ค์ธ ํ๋ก์ ํธ์์ RESTAPI๋ฅผ ๋ธ์ถ์ํฌ์์๋ค. ์คํ๋ง ๋ฐ์ดํฐ REST ์คํํฐ๊ฐ ๋น๋์ ํฌํจ๋์์ผ๋ฏ๋ก

์คํ๋ง ๋ฐ์ดํฐ๊ฐ ์์ฑํ ๋ชจ๋  ๋ ํฌ์งํ ๋ฆฌ (๋ฐ์ดํฐ JPA, ๋ฐ์ดํฐ ๋ชฝ๊ณ ) ์ REST API๊ฐ ์๋์์ฑ๋  ์ ์๋๋ก ์คํ๋ง ๋ฐ์ดํฐREST๊ฐ ์๋-๊ตฌ์ฑ๋๊ธฐ ๋๋ฌธ์ด๋ค.

์คํ๋ง ๋ฐ์ดํฐ REST๊ฐ ์์ฑํ๋ REST์๋ํฌ์ธํธ๋ ์ฐ๋ฆฌ๊ฐ ์ง์  ์์ฑํ ๊ฒ๋งํผ ์ข๋ค ๊ทธ๋ฆฌ๊ณ  ์ด ์๋ํฌ์ธํธ๋ฅผ ์ฌ์ฉํ๋ ด๋ ์ง๊ธ๊น์ง

์์ฑํ๋ `@RestController`์ ๋ธํ์ด์์ ์ง์ ๋ ๋ชจ๋  ํด๋์ค์์ ์ ๊ฑฐํด์ผํ๋ค.
```
% curl localhost:8080/ingredients
{
  "_embedded" : {
    "ingredients" : [ {
      "name" : "Flour Tortilla",
      "type" : "WRAP",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/FLTO"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/FLTO"
        }
      }
    }, {
      "name" : "Corn Tortilla",
      "type" : "WRAP",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/COTO"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/COTO"
        }
      }
    }, {
      "name" : "Ground Beef",
      "type" : "PROTEIN",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/GRBF"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/GRBF"
        }
      }
    }, {
      "name" : "Carnitas",
      "type" : "PROTEIN",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/CARN"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/CARN"
        }
      }
    }, {
      "name" : "Diced Tomatoes",
      "type" : "VEGGINES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/TMTO"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/TMTO"
        }
      }
    }, {
      "name" : "Lettuce",
      "type" : "VEGGINES",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/LETC"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/LETC"
        }
      }
    }, {
      "name" : "Cheddar",
      "type" : "CHEESE",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/CHED"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/CHED"
        }
      }
    }, {
      "name" : "Monterrey Jack",
      "type" : "CHEESE",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/JACK"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/JACK"
        }
      }
    }, {
      "name" : "Salsa",
      "type" : "SAUCE",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/SLSA"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/SLSA"
        }
      }
    }, {
      "name" : "Sour Cream",
      "type" : "SAUCE",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/ingredients/SRCR"
        },
        "ingredient" : {
          "href" : "http://localhost:8080/ingredients/SRCR"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/ingredients"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/ingredients"
    }
  }
}                                       
```
์ด๋ ๊ฒ ๋น๋์ ์์กด์ฑ๋ง ์ง์ ํ๋๋ฐ ์๋ํฌ์ธํธ๋ ๋ฌผ๋ก ์ด๊ณ  ํ์ดํผ๋งํฌ๊น์ง ํฌํจ๋ ๋ฆฌ์์ค๋ ์ป๊ฒ๋์๋ค. REST API๊ฐ ์๋์์ฑ๋์๊ธฐ ๋๋ฌธ์ด๋ค.

๋ํ 'Flour Tortilla'์ ์์์ฌ ํญ๋ชฉ์ self ๋งํฌ์ ๋ํด์๋ ํด๋ผ์ด์ธํธ์ธ ๊ฒ์ฒ๋ผ curl์ ์ฌ์ฉํด GET์์ฒญํ ์์๋ค.
```
curl http://localhost:8080/ingredients/FLTO
{
  "name" : "Flour Tortilla",
  "type" : "WRAP",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/ingredients/FLTO"
    },
    "ingredient" : {
      "href" : "http://localhost:8080/ingredients/FLTO"
    }
  }
}
```

์คํ๋ง ๋ฐ์ดํฐ REST๊ฐ ์์ฑํ ์๋ํฌ์ธํธ๋ค์ GET์ ๋ฌผ๋ก  POST, PUT, DELETE๋ฉ์๋๋ ์ง์ํ๋ค.

์คํ๋ง ๋ฐ์ดํฐ REST๊ฐ ์๋ ์์ฑํ API์ ๊ด๋ จํด์ ํ ๊ฐ์ง ํ ์ผ์ ํด๋น API์ ๊ธฐ๋ณธ ๊ฒฝ๋ก๋ฅผ ์ค์ ํ๋ ๊ฒ์ด๋ค.

ํด๋น API์ ์๋ํฌ์ธํธ๊ฐ ์์ฑํ ๋ชจ๋  ๋ค๋ฅธ ์ปจํธ๋กค๋ฌ์ ์ถฉ๋ํ์ง ์๊ฒ ํ๊ธฐ ์ํจ์ด๋ค. ์คํ๋ง ๋ฐ์ดํฐ REST๊ฐ ์๋์์ฑํ

API์ ๊ธฐ๋ณธ๊ฒฝ๋ก๋ ๋ค์๊ณผ ๊ฐ์ด spring.data.rest.base-path์์ฑ์ ์ค์ ํ๋ค.
```
spring:
    data:
        rest:
            base-path: /api
```

์ฌ๊ธฐ์๋ ์คํ๋ง ๋ฐ์ดํฐ REST ์๋ํฌ์ธํธ์ ๊ธฐ๋ณธ ๊ฒฝ๋ก๋ฅผ /apifh ์ค์ ํ์์ผ๋ฏ๋ก ์ด์ ๋ ์์์ฌ ์๋ํฌ์ธํธ๊ฐ /api/ingredients๋ค.

```
% curl http://localhost:8080/api/tacos
{
    "timestamp":"2021-02-14T05:43:52.725+00:00",
    "status":404,"error":"Not Found",
    "message":"No message available",
    "path":"/api/tacos"
}%    
```
๊ทธ๋ฌ๋ ์ด ๊ฒฝ์ฐ๋ ์์๋๋ก ์ํ๋์ง ์์๋ค. Ingredient์ IngredientRepository์ธํฐํ์ด์ค์ ๊ฒฝ์ฐ๋ ์คํ๋ง ๋ฐ์ดํฐ REST๊ฐ

/api/ingredients ์๋ํฌ์ธํธ๋ฅผ ๋ธ์ถ์์ผฐ๋๋ฐ taco์ TacoRepository์ ๊ฒฝ์ฐ ๋ธ์ถ์ํค์ง ์๋ ์ด์ ๋ ๋ฌด์์ผ๊น?

### ๐๋ฆฌ์์ค ๊ฒฝ๋ก์ ๊ด๊ณ์ด๋ฆ ์กฐ์ ํ๊ธฐ

์ค์ ๋ก๋ ์คํ๋ง ๋ฐ์ดํฐ REST๋ tacos๋ผ๋ ์๋ํฌ์ธํธ๋ฅผ ์ ๊ณตํ๋ค. ๊ทธ๋ฌ๋ ์๋ํฌ์ธํธ๋ฅผ ๋ธ์ถํ๋ ๋ฐฉ๋ฒ์ด ๋ฌธ์ ๋ค.

์ฆ ์คํ๋ง ๋ฐ์ดํฐ ๋ ํฌ์งํ ๋ฆฌ์ ์๋ํฌ์ธํธ๋ฅผ ์์ฑํ  ๋ ์คํ๋ง ๋ฐ์ดํฐ REST๋ ํด๋น ์๋ํฌ์ธํธ์ ๊ด๋ จ๋ ์ํฐํฐ ํด๋์ค ์ด๋ฆ์ ๋ณต์ํ์ ์ฌ์ฉํ๋ค.

๋ฐ๋ผ์ Ingredient์ ๊ฒฝ์ฐ๋ ์๋ํฌ์ธํธ๊ฐ /ingredients๊ฐ ๋๋ฉฐ Order๋ /orders๊ฐ๋๋ค.

๊ทธ๋ฌ๋ `taco`์ ๊ฒฝ์ฐ ๋ณต์ํ์ ์คํ๋ง๋ฐ์ดํฐ REST๊ฐ `tacoes` ๋ก ์ง์ ํ๋ฏ๋ก ์ฃผ์ํ์.

์คํ๋ง ๋ฐ์ดํฐ REST์ ๋ณต์ํ ๊ด๋ จ ๋ฌธ์ ์ ์ ํด๊ฒฐํ๋ ค๋ฉด ๋ค์๊ณผ ๊ฐ์ด ์ ๋ธํ์ด์์ ์ถ๊ฐํ๋ฉด๋๋ค
```
@Data
@Entity
@RestResource(rel="tacos",path = "tacos")
public class Taco {
```

`RestResource`์ ๋ธํ์ด์์ ์ง์ ํ๋ฉด ๊ด๊ณ์ด๋ฆ๊ณผ ๊ฒฝ๋ก๋ฅผ ์ฐ๋ฆฌ๊ฐ ์ํ๋ ๊ฒ์ผ๋ก ๋ณ๊ฒฝํ  ์ ์๋ค. 

### ๐ํ์ด์ง๊ณผ ์ ๋ ฌ

๋ชจ๋  ๋งํฌ๋ ์ ํ์  ๋งค๊ฐ๋ณ์์ธ page, size, sort๋ฅผ ์ ๊ณตํ๋ค.

์๋ฅผ๋ค์ด ํ์ด์ง ํฌ๊ธฐ๊ฐ 5์ธ ์ฒซ๋ฒ์งธ ํ์ด์ง๋ฅผ ์์ฒญํ  ๊ฒฝ์ฐ ๋ค์ GET์์ฒญ์ ํ๋ฉด๋๋ค
    
    $ curl "localhost:8080/api/tacos?size=5"

5๊ฐ์ด์์ ํ์ฝ๊ฐ ์์ด์ ๋ค์๊ณผ ๊ฐ์ด page๋งค๊ฐ๋ณ์๋ฅผ ์ถ๊ฐํ๋ฉด ๋๋ฒ์งธ ํ์ด์ง์ ํ์ฝ๋ฅผ ์์ฒญํ ์์๋ค

    $ curl "localhost:8080/api/tacos?size=5&page=1"

๋ํ sort๋ฅผ์ธ๊ฒฝ์ฐ ๋ค์๊ณผ ๊ฐ์ด ์ฌ์ฉํ  ์ ์๋ค.

    $ curl "localhost:8080/api/tacos?sort=createdAt,desc&page=0&size=12"

### ๐์ปค์คํ ์๋ํฌ์ธํธ ์ถ๊ฐํ๊ธฐ

์คํ๋ง ๋ฐ์ดํฐ REST๋ ์คํ๋ง ๋ฐ์ดํฐ ๋ ํฌ์งํ ๋ฆฌ์ CRUD ์์์ ์ํํ๋ ์๋ํฌ์ธํธ ์์ฑ์ ์ ํ๋๋กํ๋ค. ํ์ง๋ง ๋๋ก๋ 

๊ธฐ๋ณธ์ ์ธ CRUD API๋ก๋ถํฐ ํํผํ์ฌ ์ฐ๋ฆฌ ๋๋ฆ์ ์๋ํฌ์ธํธ๋ฅผ ์์ฑํด์ผ ํ  ๋๊ฐ์๋ค

์ด ๋ `@RestController` ์ ๋ธํ์ด์์ด ์ง์ ๋ ๋น์ ๊ตฌํํ์ฌ ์คํ๋ง ๋ฐ์ดํฐ REST๊ฐ ์๋์์ฑํ๋ ์๋ํฌ์ธํธ์ ๋ณด์ถฉํ ์์๋ค.

๊ทธ๋ฌ๋ ์ด๋๋ ๋ค์ ๋๊ฐ์ง๋ฅผ ๊ณ ๋ คํด์ API์ปจํธ๋กค๋ฌ๋ฅผ ์์ฑํด์ผํ๋ค
[1] ์ํธํฌ์ธํธ ์ปจํธ๋กค๋ฌ๋ ์คํ๋ง ๋ฐ์ดํฐ REST์ ๊ธฐ๋ณธ ๊ฒฝ๋ก๋ก ๋งคํ๋์ง ์๋๋ค. ๋ฐ๋ผ์ ์ด ๋๋ ์คํ๋ง ๋ฐ์ดํฐ REST์ ๊ธฐ๋ณธ ๊ฒฝ๋ก๋ฅผ

ํฌํจํ์ฌ ์ฐ๋ฆฌ๊ฐ ์ํ๋ ๊ธฐ๋ณธ ๊ฒฝ๋ก๊ฐ ์์ ๋ถ๋๋ก ๋งคํ์์ผ์ผํ๋ค. ๊ทธ๋ฌ๋ ๊ธฐ๋ณธ ๊ฒฝ๋ก๊ฐ ๋ณ๊ฒฝ๋  ๋๋ ํด๋น ์ปจํธ๋กค๋ฌ์ ๋งคํ์ด ์ผ์น๋๋๋ก ์์ ํด์ผํ๋ค

[2] ์ปจํธ๋กค๋ฌ์ ์ ์ํ ์๋ํฌ์ธํธ๋ ์คํ๋ง ๋ฐ์ดํฐ REST ์๋ํฌ์ธํธ์์ ๋ฐํ๋๋ ๋ฆฌ์์ค์ ํ์ดํผ๋งํฌ์ ์๋์ผ๋ก ํฌํจ๋์ง ์๋๋ค. ์ด๊ฒ์ ํด๋ผ์ด์ธํธ๊ฐ

๊ด๊ณ ์ด๋ฆ์ ์ฌ์ฉํด ์ปค์คํ ์๋ํฌ์ธํธ๋ฅผ ์ฐพ์ ์ ์๋ค๋ ์๋ฏธ๋ค.

---

๋จผ์  ๊ธฐ๋ณธ ๊ฒฝ๋ก์ ๊ดํ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํด๋ณด์ ์คํ๋ง ๋ฐ์ดํฐ REST๋ `@RepositoryRestController`๋ฅผ ํฌํจํ๋ค. 

์ด๊ฒ์ ์คํ๋ง ๋ฐ์ดํฐ REST์๋ํฌ์ธํธ์ ๊ตฌ์ฑ๋๋ ๊ฒ๊ณผ ๋์ผํ ๊ธฐ๋ณธ ๊ฒฝ๋ก๋ก ๋งคํ๋๋ ์ปจํธ๋กค๋ฌ ํด๋์ค์ ์ง์ ํ๋ ์๋ก์ด ์ ๋ธํ์ด์์ด๋ค

๊ฐ๋จํ ๋งํด `@RepositoryRestController`๊ฐ ์ง์ ๋ ์ปจํธ๋กค๋ฌ์ ๋ชจ๋  ๊ฒฝ๋ก ๋งคํ์ spring.data.rest.base-path ์์ฑ์ ๊ฐ์ด ์์ ๋ถ์ ๊ฒฝ๋ก๋ฅผ ๊ฐ๋๋ค

```
@RepositoryRestController
public class RecentTacosController {

    private TacoRepository tacoRepo;

    public RecentTacosController(TacoRepository tacoRepo){
        this.tacoRepo=tacoRepo;
    }

    @GetMapping(path = "/tacos/recent",produces = "application/hal+json")
    public ResponseEntity<CollectionModel<TacoResource>> recentTacos(){
        PageRequest page=PageRequest.of(0,12, Sort.by("createdAt").descending());

        List<Taco> tacos=tacoRepo.findAll(page).getContent();

        CollectionModel<TacoResource> tacoResources=  new TacoResourceAssembler().toCollectionModel(tacos);

        CollectionModel<TacoResource> recentResources=new CollectionModel<>(tacoResources); //์ฑ์ ์๋ ๋ฐฉ์๋๋ก List๋ก ํ๋๊ฒ์ ๋์ง์๋๋ค.
        // ์ฝ๋๋ฅผ ์ ๊ณตํ์ง ์์๋ฟ๋๋ผ ๊ฐ์ ํ๋ณํ์ ํ๋๋ผ๋ ์๋ฌ๊ฐ๋ธ ๋ฐ๋ผ์ ์ด๋ ๊ฒ ํ์์ ๋ณ๊ฒฝํจ์ผ๋ก์จ ์ฑ์ด ์ํ๋ ๋ต์ ๋.

        recentResources.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecentTacosController.class).recentTacos())
        .withRel("recents"));
        return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }
}
```

์ฌ๊ธฐ์ @GetMapping์ /tacos/recent๊ฒฝ๋ก๋ก ๋งคํ๋์ง๋ง, RecentTacosControllerํด๋์ค์ @RepositoryRestController์ ๋ธํ์ด์์ด

์ง์ ๋์ด์์ผ๋ฏ๋ก ๋งจ์์ ์คํ๋ง ๋ฐ์ดํฐ REST์ ๊ธฐ๋ณธ๊ฒฝ๋ก๊ฐ ์ถ๊ฐ๋๋ค ๋ฐ๋ผ์ recentTacos()๋ฉ์๋๋ /api/tacos/recent ์ GET์์ฒญ์ ์ฒ๋ฆฌํ๊ฒ๋๋ค.

์ฌ๊ธฐ์ ํ ๊ฐ์ง ์ฆ์ํ๊ฒ์ด์๋ค. @RepositoryRestController๋ @RestController์ ์ด๋ฆ์ด ์ ์ฌํ์ง๋ง, @RestController์

๋์ผํ ๊ธฐ๋ฅ์ ์ํํ์ง์๋๋ค. ํนํ @RepositoryRestController๋ ํธ๋ค๋ฌ ๋ฉ์๋์ ๋ฐํ๊ฐ์ ์์ฒญ ์๋ต์ ๋ชธ์ฒด์ ์๋์ผ๋ก ์๋กํ์ง ์๋๋ค.

๋ฐ๋ผ์ ํด๋น ๋ฉ์๋์ @ResponseBody์ ๋ธํ์ด์์ ์ง์ ํ๊ฑฐ๋ ํด๋น ๋ฉ์๋์์ ์๋ต๋ฐ์ดํฐ๋ฅผ ํฌํจํ๋ ResponseEntity๋ฅผ ๋ฐํํด์ผํ๋ค.

์ด์  ์คํ๋๋ฉด /api/tacos/recent์ Get์์ฒญ์ ํ  ๋ ๊ฐ์ฅ ์ต๊ทผ์ ์์ฑ๋ ํ์ฝ๋ฅผ 12๊ฐ๊น์ง ๋ฐํํ๋ค. ๊ทธ๋ฌ๋ /api/tacos๋ฅผ

์์ฒญํ  ๋๋ ์ฌ์ ํ ํ์ดํผ๋งํฌ ๋ฆฌ์คํธ์ ๋ํ๋์ง์์๊ฒ์ด๋ค.. ์ด๊ฑธ ํด๊ฒฐํด์ผํ๋ค!

### ๐์ปค์คํ ํ์ดํผ๋งํฌ๋ฅผ ์คํ๋ง ๋ฐ์ดํฐ ์๋ํฌ์ธํธ์ ์ถ๊ฐํ๊ธฐ

์ต๊ทผ์ ์์ฑ๋ ํ์ฝ์ ์๋ํฌ์ธํธ๊ฐ /api/tacos์์ ๋ฐํ๋ ํ์ดํผ๋งํฌ ์ค์ ์๋ค๋ฉด ํด๋ผ์ด์ธํธ๊ฐ ๊ฐ์ฅ ์ต๊ทผ  ํ์ฝ๋ค์ ๊ฐ์ ธ์ค๋

๋ฐฉ๋ฒ์ ์ด๋ป๊ฒ ์ ์ ์์๊น? ์ถ๋ก ์ํ๊ฑฐ๋ ํ๋ ๋ฐฉ์์ด๋ ํ๋์ฝ๋ฉํด์ผํ ๊ฒ์ด๋ค.

๊ทธ๋ฌ๋ ๋ฆฌ์์ค ํ๋ก์ธ์ ๋น์ ์ ์ธํ๋ฉด ์คํ๋ง ๋ฐ์ดํฐ REST๊ฐ ์๋์ผ๋ก ํฌํจ์ํค๋ ๋งํฌ๋ฆฌ์คํธ์ ํด๋น ๋งํฌ๋ฅผ ์ถ๊ฐํ  ์ ์๋ค.

์คํ๋ง ๋ฐ์ดํฐ HATEOAS๋ RepresentationModelProcessor๋ฅผ ์ ๊ณตํ๋ค. ์ด๊ฒ์ API๋ฅผ ํตํด ๋ฆฌ์์ค๊ฐ ๋ฐํ๋๊ธฐ ์ ์ ๋ฆฌ์์ค๋ฅผ ์กฐ์ํ๋ ์ธํฐํ์ด์ค์ด๋ค.
 
```
์ปค์คํ ๋งํฌ๋ฅผ ์คํ๋ง ๋ฐ์ดํฐ REST ์๋ํฌ์ธํธ์ ์ถ๊ฐํ๊ธฐ
@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public RepresentationModelProcessor<PagedModel<EntityModel<Taco>>> tacoProcessor(EntityLinks links){
        return model -> {
            model.add(
                    links.linkFor(Taco.class)
                    .slash("recent")
                    .withRel("recents")
            );
            return model;
        };
    }
}

```

์ด๊ฒฝ์ฐ PagedNodel< EntityModel< Taco>>๊ฐ ๋ฐํ๋๋ฉด ๊ฐ์ฅ ์ต๊ทผ์ ์์ฑ๋ ํ์ฝ๋ค์ ๋งํฌ๋ฅผ ๋ฐ๊ฒ๋๋ฉฐ /api/tacos์์ฒญ์๋ต์๋ ํด๋น ๋งํฌ๋ค์ด ํฌํจ๋๋ค.

# ๐ฅ6์ฅ ์์ฝ
### [๐1] REST์๋ํฌ์ธํธ๋ ์คํ๋ง MVC, ๊ทธ๋ฆฌ๊ณ  ๋ธ๋ผ์ฐ์  ์งํฅ์ ์ปจํธ๋กค๋ฌ์ ๋์ผํ ํ๋ก๊ทธ๋๋ฐ

### ๋ชจ๋ธ์ ๋ฐ๋ฅด๋ ์ปจํธ๋กค๋ฌ๋ก ์์ฑํ  ์ ์๋ค.

### ๐[2] ๋ชจ๋ธ๊ณผ ๋ทฐ๋ฅผ ๊ฑฐ์น์ง์๊ณ  ์์ฒญ ์๋ต ๋ชธ์ฒด์ ์ง์  ๋ฐ์ดํฐ๋ฅผ ์ฐ๊ธฐ ์ํด ์ปจํธ๋กค๋ฌ์ ํธ๋ค๋ฌ ๋ฉ์๋์๋ 

### @ResponseBody์ ๋ธํ์ด์์ ์ง์ ํ  ์ ์์ผ๋ฉฐ, ResponseEntity๊ฐ์ฒด๋ฅผ ๋ฐํํ ์์๋ค

### ๐[3] @RestController์ ๋ธํ์ด์์ ์ปจํธ๋กค๋ฌ์ ์ง์ ํ๋ฉด ํด๋น ์ปจํธ๋กค๋ฌ์ ๊ฐ ํธ๋ค๋ฌ

### ๋ฉ์๋์ @ResponseBody๋ฅผ ์ง์ ํ์ง ์์๋ ๋๋ฏ๋ก ์ปจํธ๋กค๋ฌ๋ฅผ ๋จ์ํํด์ค๋ค

### ๐[4] ์คํ๋ง HATEOAS๋ ์คํ๋ง MVC์์ ๋ฐํ๋๋ ๋ฆฌ์์ค์ ํ์ดํผ๋งํฌ๋ฅผ ์ถ๊ฐํ  ์ ์๊ฒํ๋ค.

### ๐[5]์คํ๋ง ๋ฐ์ดํฐ ๋ ํฌ์งํ ๋ฆฌ๋ ์คํ๋ง ๋ฐ์ดํฐ REST๋ฅผ์ฌ์ฉํ๋ REST API๋ก ์๋๋ธ์ถ๋  ์ ์๋ค.


## ๐์คํ๋ฐฉ๋ฒ
	
	1. mvnw clean package
	2. cd chap6\taco-cloud\target
	3. java -jar taco-cloud-0.0.1-SNAPSHOT.jar

## ๐์ฑ๊ณผ ๋ฌ๋ฆฌ ์ต์ ๋ฒ์ ผ์ ์คํ๋ง๋ถํธ ์ฝ๋๋ก ํ์์ผ๋ฉฐ ์๋ธ๋ชจ๋์ ์ค์ง ๋๊ฐ๋กํ์์ต๋๋ค.

























