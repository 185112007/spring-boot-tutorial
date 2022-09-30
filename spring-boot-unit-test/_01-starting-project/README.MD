# Junit Temelleri

## Test sinifi ve metodlari hakkinda

Test sinifi package private olması gerekir. Yani herhangi bir
erisim turunu belirmeyecegiz, default olarak package private 
olacaktir. Public, protected veya private gibi erisim izinleri
yazmayacagiz.

Yukarida bahsettigim erisim izinler aynı zamanda test metodlar icin
de gecerlidir. Test metodlari da package private olarak tanimlanir.

## Annotasyonlar

### @Test annotasyonu

@Test - bir metodun JUnit frameworku tarafindan test edilecek
metod oldugunu fark edebilmesi icin @Test annotasyonu metod
arayuzunun basinda yazilir.

### @BeforeEach ve @AfterEach

#### @BeforeEach annotasyonu

@BeforeEach - bir metodun her bir test metodu oncesinde calismasini
saglamak icin o metod arayuzu oncesinde @BeforeEach annotasyonu ile
annote edilir.

#### @AfterEach annotasyonu

@AfterAll - bir metodun her bir test metodu sonrasinda calismasini
saglamak icin o metod arayuzu oncesinde @AfterEach annotasyonu ile
annote edilir.

### @BeforeAll ve @AfterAll

#### @BeforeAll annotasyonu

@BeforeAll - bir metodun bir sinif icindeki tum test metodlarindan
once sadece bir kere calismasini saglamak icin metod arayuzu oncesinde
@BeforeAll annotasyonu ile annote edilir.

#### @AfterAll annotasyonu

@AfterAll - bir metod bir sini icindeki tum test metodlarindan
sonra sadece bir kere calismasini saglamak icin metod arayuzu oncesinde
@AfterAll annotasyonu ile annote edilir.

__Note__: @BeforeAll ve @AfterAll annotasyonu ile annote edilmis
metodlar static olmak zorundadir.

#### @DisplayName(title)

@DisplayName - test sinifi veya test metodu icin ozel bir gorunen ad 
bildirmek icin kullanilir.

## Assertions

### Equals & NotEquals

assertEqual(expected, actual, message) - seklinde bir
arayuzu vardir. 

- expected - test metodunu calistirdiktan
sonra beklediginiz degerdir.
- actual - test metodunu calistirdiktan sonra aldiginiz sonuctur
- message - test metodu basarisiz oldugunda konsola yazilacak mesajdir

assertNotEquals(unexpected, actual, message) - 
seklinde bir arayuzu vardir.

- unexpected - test metodu calistirdiktan sonra beklemediginiz deger

### Null & NotNull

assertNull(actual, message) - seklinde bir arayuzu vardir. Burada
bir test metodu calistiktan sonra null dondururse, test basarilidir,
aksi durumda fail olur.

assertNotNull(actual, message) - seklinde bir arayuzu vardir. Bir
metod cagrildiginda null dondurmezse test basarilidir, aksi halde fail olur.

### True & False

assertTrue(condition, message) - seklinde bir arayuzu vardir. Bir metod
calistiginda geriye true dondururse basarilidir, aksi durumda fail olur.

assertFalse(condition, message) - seklinde arayuzu vardir. Metod 
calistiginda geriye false dondurulurse basarilidir, aksi durumda
fail olur.

### Same & NotSame

assertSame(expected, actual, message) - seklinde bir arayuzu vardir. Bir
metod calistirildiginda expected ve actual objeleri ayni objeye referans
ediyorlarsa basariliri, aksi durumda fail olur.

assertNotSame(unexpected, actual, message) - seklinde arayuzu vardir. Bir
metod calistirildiginda expected ve actual objeler farkli objeye referans
ediyorlarsa test basarilidir, aksi durumda fail olur.

### ArrayEquals, IterableEquals, LinesMatch

assertArrayEquals(expected[], actual[], message) - arayuzu vardir. Bir metod 
calistirildiginda expected ve actual dizi elemanlari bir birine esitse basarilidir,
aksi durumda fail olur.

```
String[] str1 = {"A", "B", "C"};
String[] str1 = {"A", "B", "C"};

assertArrayEquals(str1, str2, "Arrays should be the same");
// success
```

assertIterableEquals(Iterable<?> expected, Iterable<?> actual, message) - arayuzu
vardir. Metod calistirildiginda expected ve actual list elemanlari bir birine
esit ise basarilidir, aksi halde fail olur.

```
List<String> theList1 = List.of("A", "B", "C");
List<String> theList2 = List.of("A", "B", "C");

assertIterableEquals(theList1, theList2, 
    "Expected list should be same as actual list");
// success
```

assertLinesMatch(List<String> expected, List<String> actual, message) - arayuzu vardir.
expected ve actual string liste elemanlari birbirine esit ise basarili, aksi durumda
fail olur.

```
List<String> theList1 = List.of("A", "B", "C");
List<String> theList2 = List.of("A", "B", "C");

assertLinesMatch(theList1, theList2, 
    "Lines should match");
// success
```

### Throws ve DoesNotThrow

assertThrows(expectedType, executable, message) - seklinde arayuzu vardir. executable calistirildiginda
expectedType tipinde bir exception firlatilirsa test basarilidir, aksi durumda fail olur.

assertDoesNotThrow(executable, message) - seklinde bir arayuzu vardir. executable calistiginda
herhangi bir exception firlatmiyorsa test basarilidir, aksi durumda fail olur.

## Ordering

Bir test sinifina ait test metodlarini belli bir sira ile calismasini saglamak icin @TestMethodOrder annotasyonu
kullanilir. Farkli siralama yontemleri mevcuttur: metod ismine, display name'ine, veya direkt olarak her bir 
metodu @Order ile annote ederek siralanabilir.

### @TestMethodOrder(MethodOrderer.MethodName.class)

MethodOrderer.MethodName - metod ismine gore test metodlarini siralar.

### @TestMethodOrder(MethodOrderer.DisplayName.class)

MethodOrderer.DisplayName - adindanda anlasildigi gibi, @DisplayName'ine gore siralama yapacaktir.

### @TestMethodOrder(MethodOrderer.OrderAnnotation.class) & @Order(priority)

OrderAnnotation - bu annotasyon ile istedigimiz test metodu arayuzunde @Order ile calistirma onceligi verebiliris.
Priority degeri ne kadar kucuk ise onceligi daha yuksektir(burada eksi sayilarda verilebilir)

## Code Coverage with Maven

Maven JUnit 5 testlerini yakalayabilmesi icin maven-surefire-plugin pluginini pom.xml eklenmelidir.

```xml

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M5</version>
        </plugin>
    </plugins>
</build>
```