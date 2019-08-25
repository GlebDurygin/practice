# Practice
## Анализ возможностей криптографических библиотек на языке Java
Исследуемые библиотеки:
* Bouncy Castle
* JCA (Java Cryptography Architecture)

В данной работе проверяются возможности криптографических библиотек на языке Java. Сравнение идет по двум критериям: времени выполнения и количества затрачиваемой памяти.
Проверялись следующие базовые криптографческие алгоритмы:
* Хэш-функции - функция генерации хеша запускается 16000 раз. Результат выполнения функции поступает на вход хеш функции на следующем шаге;
* Цифровые подписи - генерация цифровой подписи и ее проверка;
* Генераторы случайных чисел - генерирование случайных чисел пока для сгенерированного числа не превысит 1 мегабайт.

### Главный экран
![](images/main-screen.PNG)

В данном экране можно создать сущность "Algorithm".
### Экран редактирования алгоритмов
![](images/editor.PNG)

С помощью кнопки "Refresh Info" вычислить время и количество памяти, которое затрачивает компилятор при запуске выбранной функции.
### Хеш-фукции
#### Хеш-фукции (время выполнения, миллисекунды)
![](images/hash-functions-time.PNG)
#### Хеш-фукции (затрачиваемая память, кБайт)
![](images/hash-functions-memory.PNG)

Рассмотренные хеш-функции:
* Gost R 34.11-94
* MD2
* MD4
* MD5
* SHA-1
* SHA-224
* SHA-256
* SHA-384
* SHA-512
* Tiger
* RIPEMD128
* RIPEMD160
* RIPEMD256
* RIPEMD320
* WhirlpoolDigest
### Цифровые подписи
#### Цифровые подписи (время выполнения, миллисекунды)
![](images/sign-time.PNG)
#### Цифровые подписи (затрачиваемая память, кБайт)
![](images/sign-memory.PNG)
Рассмотренные алгоритмы цифровой подписи:
* DSA
* RSA
* ECDSA

### Генераторы случаных чисел
#### Генераторы случаных чисел (время выполнения, миллисекунды)
![](images/random-time.PNG)
#### Генераторы случаных чисел (затрачиваемая память, кБайт)
![](images/random-memory.PNG)
Генераторы случайных чисел на дайджестах со счетчиком:
* Random generation based on Gost R 34.11-94
* Random generation based on MD2
* Random generation based on MD4
* Random generation based on MD5
* Random generation based on SHA-1
* Random generation based on SHA-224
* Random generation based on SHA-256
* Random generation based on SHA-384
* Random generation based on SHA-512
* Random generation based on Tiger
* Random generation based on RIPEMD128
* Random generation based on RIPEMD160
* Random generation based on RIPEMD256
* Random generation based on RIPEMD320
* Random generation based on WhirlpoolDigest

### Вспомогательные ссылки
* [The Bouncy Castle FIPS Java API in 100 Examples (Final Draft)](https://www.bouncycastle.org/fips-java/BCFipsIn100.pdf)
* [Bouncy Castle git repository](https://github.com/bcgit/bc-java)
* [Bouncy Castle documentation](https://www.bouncycastle.org/documentation.html)
* [Java Cryptography Architecture](https://github.com/dsiproject/krypton)
* [Handbook Applied Cryptography](https://doc.lagout.org/network/3_Cryptography/CRC%20Press%20-%20Handbook%20of%20applied%20Cryptography.pdf)
