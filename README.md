## Ссылки на документацию

* [Plan](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Plan.md)
* [Report](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Report.md)
* [Summary](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Summery.md)

## Процедура запуска тестов сервиса покупки путешествий для MySql
* Установить на рабочий компьютер ПО Putty, инструкция и ссылка на дистрибутив [тут](https://github.com/netology-code/aqa-homeworks/blob/master/docker/timeweb-instruction.md)
* Подключиться к виртуальной машине ip 185.119.57.47
* Клонировать [репозиторий](https://github.com/Chikhareva/Diplom2) на локальную машину.
* Перейти в каталог проекта
* На виртуальной машине запускаем контейнеры MySql и Node c помощью команды docker-compose up -d --force-recreate.
* Проверяем, что контейнеры запустились командой docker-compose ps.
* Из командной строки windows локальной машины запускаем приложение и передаем данные для подключения базы MySql командой java -Dspring.datasource.url=jdbc:mysql://185.119.57.47:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -Durl="jdbc:mysql://185.119.57.47:3306/app" -jar artifacts/aqa-shop.jar
* Из командной строки локальной машины windows запускаем тесты командой gradlew clean test -Durl="jdbc:mysql://185.119.57.47:3306/app" -Duser="user" -Dpassword="pass" --info
* Из командной строки локальной машины Windows выполнить команду gradlew allureReport, для формирования нужных файлов
* В командной строке локальной машины windows формируем отчет командой gradlew allureServe
* Проводим оценку результатов тестирования.

## Процедура запуска тестов сервиса покупки путешествий для PostgreSQL
* Установить на рабочий компьютер ПО Putty, инструкция и ссылка на дистрибутив [тут](https://github.com/netology-code/aqa-homeworks/blob/master/docker/timeweb-instruction.md)
* Подключиться к виртуальной машине ip 185.119.57.47
* Клонировать [репозиторий](https://github.com/Chikhareva/Diplom2) на локальную машину.
* Перейти в каталог проекта. 
* На виртуальной машине запускаем контейнеры PostgreSQL и Node c помощью команды docker-compose up -d --force-recreate.
* Проверяем, что контейнеры запустились командой docker-compose ps.
* Из командной строки локальной машины windows запускаем приложение и передаем данные для подключения базы PostgreSQL командой java -Dspring.datasource.url=jdbc:postgresql://185.119.57.47:5432/appps -Dspring.datasource.username=userps -Dspring.datasource.password=passps -jar artifacts/aqa-shop.jar
* Из командной строки локальной машины windows запускаем тесты командой gradlew clean test -Durl="jdbc:postgresql://185.119.57.47:5432/appps" -Duser="userps" -Dpassword="passps" --info
* Из командной строки локальной машины Windows выполнить команду gradlew allureReport, для формирования нужных файлов
* В командной строке локальной машины windows формируем отчет командой gradlew allureServe
* Проводим оценку результатов тестирования.
