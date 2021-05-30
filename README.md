## Ссылки на документацию

* [Plan](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Plan.md)
* [Report](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Report.md)
* [Summary](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Summary.md)

## Процедура запуска тестов сервиса покупки путешествий для MySql

* Клонировать [репозиторий](https://github.com/Chikhareva/Diplom2) на локальную машину.
* Перейти в каталог проекта
* Запустить контейнеры MySql и Node c помощью команды docker-compose up -d --force-recreate.
* Проверить, что контейнеры запустились командой docker-compose ps.
* Из командной строки windows локальной машины запускаем приложение и передаем данные для подключения базы MySql командой java -Durl=jdbc:mysql://localhost:3306/app -Dusername=user -Dpassword=pass -Durl="jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
* Из командной строки локальной машины windows запускаем тесты командой gradlew clean test -Durl="jdbc:mysql://localhost:3306/app" -Duser="user" -Dpassword="pass" --info
* Из командной строки локальной машины Windows выполнить команду gradlew allureReport, для формирования нужных файлов
* В командной строке локальной машины windows формируем отчет командой gradlew allureServe
* Проводим оценку результатов тестирования.

## Процедура запуска тестов сервиса покупки путешествий для PostgreSQL

* Клонировать [репозиторий](https://github.com/Chikhareva/Diplom2) на локальную машину.
* Перейти в каталог проекта. 
* На виртуальной машине запускаем контейнеры PostgreSQL и Node c помощью команды docker-compose up -d --force-recreate.
* проверить, что контейнеры запустились командой docker-compose ps.
* Из командной строки локальной машины windows запустить приложение и передаем данные для подключения базы PostgreSQL командой java -Durl=jdbc:postgresql://localhost:5432/appps -Dusername=userps -Dpassword=passps -jar artifacts/aqa-shop.jar
* Из командной строки локальной машины windows запустить тесты командой gradlew clean test -Durl="jdbc:postgresql://localhost:5432/appps" -Duser="userps" -Dpassword="passps" --info
* Из командной строки локальной машины Windows выполнить команду gradlew allureReport, для формирования нужных файлов
* В командной строке локальной машины windows сформировать отчет командой gradlew allureServe
* Проводим оценку результатов тестирования.
