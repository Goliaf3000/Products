# REST API для интернет магазина.
Проект подготовлен на языке Javaс использованием фрэймворка Spring Boot, имеется подключение зависимостей при помощи фреймворка для автоматизации сборки проектов на основе описания их структуры в файлах на языке POM, также хранятся комиты и ветви процесса разработки API при помощи системы контроля версий Git.
Сервис работает на порте 8088, порт можно изменить в файле properties проекта, а также в файле Dockerfile. База данных Postgresql работает по порту 5432.
Требования к окружению:
* Установка JDK (версия java 23)
* Установка maven для сборки проекта
* Установка git для версионирования
* Установка Docker

## Работа проекта
* В ветве T1 имеется API, хранящая объекты продукты при помощи MAP в формате ключ – значение.
В ветве Т2 была добавлена БД при помощи PostgreSQL, теперь данные не пропадают после закрытия приложения. Если таблицы нет, то сервис сам ее создаст.
Ветвь Т3 реализует процесс контейниризации посредствам прилолжения Docker и файлов Dockerfile и docker-compose
Имеется фильтр, изменить их можно в пакете Controller:
по текущей цене, а также в зав от min & max результат http://localhost:8088/products?maxPrice=8&minPrice=8
по имени http://localhost:8088/products?productName=1ddddd
по наличию: http://localhost:8088/products?productStock=не в наличии
Сортировка:
по имени (по убыванию)http://localhost:8088/products?sortBy=productName&sortDir=asc
по имени(по возрастанию)
http://localhost:8088/products?sortBy=productName&sortDir=desc
Сортировка по цене товара (по возрастанию):
http://localhost:8088/products?sortBy=productPrice&sortDir=asc
Сортировка по цене товара (по убыванию):
http://localhost:8088/products?sortBy=productPrice&sortDir=desc
Для проверки работы валидатора используй запросы:
http://localhost:8088/products?minPrice=-100
http://localhost:8088/products?sortBy=invalidField
