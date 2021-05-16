## Ссылки на документацию

* [Plan](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Plan.md)
* [Report](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Report.md)
* [Summery](https://github.com/Chikhareva/Diplom2/blob/master/DiplomDocs/Summery.md)

## Процедура запуска тестов сервиса покупки путешествий для MySql
* Установить на рабочий компьютер ПО Putty, инструкция и ссылка на дистрибутив [тут](https://github.com/netology-code/aqa-homeworks/blob/master/docker/timeweb-instruction.md)
* Подключиться к виртуальной машине ip 185.119.57.47
* Запустить Docker командой 
* Клонировать [репозиторий](https://github.com/Chikhareva/Diplom2) на виртуальную машину.
* Перейти в каталог проекта cd Diplom2
* Запускаем контейнеры MySql и Node c помощью команды docker-compose up -d --force-recreate.
* Проверяем, что контейнеры запустились командой docker-compose ps? состояние контейнера UP.
* Из командной строки windows запускаем приложение и передаем данные для подключения базы MySql командой java -Dspring.datasource.url=jdbc:mysql://185.119.57.47:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -Durl="jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar
* Из командной строки windows запускаем тесты командой gradlew clean test -Durl="jdbc:mysql://185.119.57.47:3306/app" -Duser="user" -Dpassword="pass" --info
* В командной строке windows формируем отчет командой gradlew allureServe(возможно первый раз нужно будет сначала выполнить команду gradlew allureReport, для формирования нужных файлов)
* Проводим оценку результатов тестирования.

## Процедура запуска тестов сервиса покупки путешествий для PostgreSQL
* Установить на рабочий компьютер ПО Putty, инструкция и ссылка на дистрибутив [тут](https://github.com/netology-code/aqa-homeworks/blob/master/docker/timeweb-instruction.md)
* Подключиться к виртуальной машине ip 185.119.57.47
* Запустить Docker командой 
* Клонировать [репозиторий](https://github.com/Chikhareva/Diplom2) на виртуальную машину.
* Перейти в каталог проекта cd Diplom2
* Запускаем контейнеры PostgreSQL и Node c помощью команды docker-compose up -d --force-recreate.
* Проверяем, что контейнеры запустились командой docker-compose ps, состояние контейнера UP.
* Из командной строки windows запускаем приложение и передаем данные для подключения базы PostgreSQL командой java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/appps -Dspring.datasource.username=userps -Dspring.datasource.password=passps -jar artifacts/aqa-shop.jar
* Из командной строки windows запускаем тесты командой gradlew clean test -Durl="jdbc:postgresql://localhost:5432/appps" -Duser="userps" -Dpassword="passps" --info
* В командной строке windows формируем отчет командой gradlew allureServe(возможно первый раз нужно будет сначала выполнить команду gradlew allureReport, для формирования нужных файлов).
* Проводим оценку результатов тестирования.
