https://mentee-power.xl.ru/learn/QtnU6_RY1kyRRKXrbILJ2Q/theory

Quick Start: run - Tasks → application → run; build - Tasks → build → Run; test - Task→verification→test; Run Anything (Ctrl+Ctrl): gradle build(сборка), gradle run(запуск), gradle test(тест)

Пакет ru.mentee.power: Пакет (package) это способ логически сгруппировать классы и задать им «адрес», чтобы код был понятным, не конфликтовал и был безопасным. 

menteeName (String) - имя стажера; sprintNumber (int) - номер спринта; plannedHoursPerWeek (int) - запланированные часы в неделю; readyForSprint() - бизнес-логика (стажёр считается готовым к спринту, если у него запланировано не меньше N часов)

git config --global user.name/email - проверяем в Settings → Version Control → Git → Test

Правило качества: перед каждым git push обязательно выполняй git status и убедись, что статус — nothing to commit, working tree clean (или что в Commit Tool Window нет лишних файлов).
Где проверять:

В IDE: Commit Tool Window (Ctrl+K) — списки Unversioned/Changes должны быть пустыми или содержать только ожидаемые файлы.
В CLI: git status — должен показывать «nothing to commit, working tree clean»

Сценарий ручной проверки DVT-6

Запуск приложения
> Task :run
Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

BUILD SUCCESSFUL in 10s
2 actionable tasks: 2 executed

> Task :test

MenteeProgressTest > shouldFormatSummaryWhenProgressCreated() PASSED

MenteeProgressTest > shouldDetectLackOfReadinessWhenHoursBelowThreshold() PASSED

MenteeProgressTest > shouldDetectReadinessWhenHoursAboveThreshold() PASSED

Тестирование ProgressTracker > Конструктор Mentee должен выбрасывать исключение, если completedLessons > totalLessons PASSED

Тестирование ProgressTracker > Все mentee завершили курс — осталось 0 PASSED

Тестирование ProgressTracker > Конструктор Mentee должен выбрасывать исключение при отрицательном completedLessons PASSED

Тестирование ProgressTracker > Суммарный прогресс для нескольких mentee с разным прогрессом PASSED

Тестирование ProgressTracker > Конструктор Mentee не должен выбрасывать исключение при корректных данных PASSED

Тестирование ProgressTracker > Конструктор Mentee должен выбрасывать исключение, если completedLessons > totalLessons PASSED

Тестирование ProgressTracker > Все mentee завершили курс — осталось 0 PASSED

Тестирование ProgressTracker > Конструктор Mentee должен выбрасывать исключение при отрицательном completedLessons PASSED

Тестирование ProgressTracker > Суммарный прогресс для нескольких mentee с разным прогрессом PASSED

Тестирование ProgressTracker > Конструктор Mentee не должен выбрасывать исключение при корректных данных PASSED

StudentListTest > addStudentAddsOneStudentListSizeIncreases() PASSED

StudentListTest > addStudentAddsStudentToList() PASSED

StudentListTest > getStudentsByCityWithNullOrEmptyCityReturnsEmptyList() PASSED

StudentListTest > getStudentsByCityReturnsOnlyStudentsFromThatCity() PASSED

BUILD SUCCESSFUL in 6s
5 actionable tasks: 5 executed

## Debug/Evaluate Expression
Скриншот окна Evaluate Expression: вывод корректен, кодировка UTF-8 работает.

Проверка DVT‑6

1. Открыть `ProgressTracker.java`, поставить breakpoint на строку внутри цикла `while`.
2. Запустить в режиме Debug (значок 🐞 рядом с `main`).
3. В момент остановки открыть Evaluate Expression (Alt+F8) и проверить выражение `totalCompleted + mentees[index].completedLessons()` — после 2-й итерации оно равно `25`
4. В панели Variables убедиться, что `totalCompleted` меняется при нажатии F8.


## Кодстайл-гайд
RedundantImport
До import java.util.List;
import java.util.List;
После import java.util.List;
Почему:Дублирование строки чревато рассинхронизацией и багами
https://checkstyle.org/checks/imports/redundantimport.html

EmptyBlock
До if (true) { }
После строка была убрана (добаление было для выполнения задания).
Почему: Чаще всего это признак недописанного кода
https://checkstyle.org/checks/blocks/emptyblock.html

MethodName
До public void  add_Student (Student student) {
После public void  addStudent (Student student) {
Почему: Код не скомпилируется, а так же вызовет вопросу на равью
https://checkstyle.org/checks/naming/methodname.html

MethodName
До public List<Student> GETStudentsByCity(String city) {
После public List<Student> getStudentsByCity(String city) {
Почему: В Java методы всегда начинаются со строчной (маленькой) буквы
https://checkstyle.org/checks/naming/methodname.html


NeedBraces
До if (city == null || city.isEmpty())
return new ArrayList<>();
После if (city == null || city.isEmpty()) {
return new ArrayList<>();
}
Почему:Отсутствие фигурных скобок сильно повышает риск ошибок
https://checkstyle.org/checks/blocks/needbraces.html

NeedBraces
До   for (int i = 0; i < 5; i++)
System.out.println(i);
После   for (int i = 0; i < 5; i++) {
System.out.println(i);
}
Почему:Отсутствие фигурных скобок сильно повышает риск ошибок
https://checkstyle.org/checks/blocks/needbraces.html

LineLength
До String veryLongText = "This is a very long line that intentionally exceeds the Checkstyle LineLength limit of 120 characters to demonstrate how the rule works and catches this specific kind of formatting issue.";
После строка была убрана (добаление было для выполнения задания).
Почему: Затрудняет проведению ревью, при выводе не всегда понятно, какие именно были изменения
https://checkstyle.org/checks/sizes/linelength.html

WhitespaceAround
До public int size(){
После public int size() {
Почему: Повышает читаемость кода
https://checkstyle.org/checks/whitespace/whitespacearound.html


## Быстрая проверка

Выполни в терминале:

./gradlew checkstyleMain 
./gradlew test
./gradlew jacocoTestCoverageVerification


## Self-review: Debug, фактические значения и путь «упало → починил»

### Фактическое значение students.size() из Debug
Для проверки логики добавления студентов был выполнен Debug теста `StudentListTest.testAddStudent`.

- Breakpoint установлен на строке внутри метода `StudentList.addStudent` (перед `students.add(student)`).
- Запуск: Debug для теста `StudentListTest`.
- Проверка через Evaluate Expression: выражение `students.size()` дало следующие значения:
  - Перед первым добавлением: students.size() = 0.
  - После первого добавления : students.size() = 1.
  - После второго добавления: students.size() = 2.

### Checkstyle: подтверждение severity=error и severity=warning

### Демонстрация warning (LineLength)
- В ProgressTracker была создана строка длиной 123 символа.
- Команда: `./gradlew checkstyleMain`.
- Результат: предупреждение `LineLength` (severity=warning), сборка прошла.
- Исправление: строка исправлена, нарушений нет.

### Демонстрация error (NeedBraces)
- В ProgressTracker был создан `if` без фигурных скобок.
- Команда: `./gradlew checkstyleMain`.
- Результат: ошибка `NeedBraces` (severity=error), сборка упала.
- Исправление: добавлены фигурные скобки `{}`, сборка чистая.

### Финальный статус
- Все нарушения исправлены.
- `Total violations: 0`.
- Отчёт: `build/reports/checkstyle/main.html`.

## JaCoCo: покрытие 88% 

1. Запуск верификации: `./gradlew jacocoTestCoverageVerification`.
2. Первоначальный результат: покрытие ниже 80% (были непокрытые ветки в `ProgressTracker` и нулевое покрытие 'ProgressDemo').
3. Исправление: добавлены тесты в `ProgressLoopTest.java`, в build.gradle внесено правило исключения 'ProgressDemo' из покрытия.
4. Итоговый результат: покрытие 88%, сборка успешна.
5. Отчёт: `build/reports/jacoco/test/html/index.html`.

## Ошибка:
https://github.com/smuki14/devtools/actions/runs/30572200312
## Исправление:
https://github.com/smuki14/devtools/actions/runs/30573721946

## Бейдж статус CI:
[![Java CI](https://github.com/smuki14/devtools/actions/workflows/ci.yml/badge.svg)](https://github.com/smuki14/devtools/actions/workflows/ci.yml)

## Code Review Checklist

### Функциональность
- [ ] Код решает поставленную задачу полностью
- [ ] Обработаны граничные случаи (null, пустые данные, экстремальные значения)
- [ ] Обработка ошибок реализована корректно

### Тесты
- [ ] Добавлены тесты для нового функционала
- [ ] Все тесты проходят локально: ./gradlew test
- [ ] Покрыты позитивные и негативные сценарии
- [ ] JaCoCo coverage >= 80% для нового кода

### Читаемость и стиль
- [ ] Имена переменных, методов и классов отражают назначение
- [ ] Нет дублирования кода (DRY)
- [ ] Checkstyle проходит без ошибок: ./gradlew checkstyleMain
- [ ] Нет закомментированного кода или отладочного вывода (System.out.println)

### Документация
- [ ] README обновлён (если добавлена новая функциональность)
- [ ] Публичные методы имеют JavaDoc (если применимо)
- [ ] Runbook обновлён (если изменились команды)

### Производительность и безопасность
- [ ] Нет очевидных проблем производительности
- [ ] Нет хардкода паролей, токенов или конфиденциальных данных

**Проблема:** [конкретное описание с указанием строки]
**Почему это важно:** [последствия]
**Предложение:** [как исправить или альтернатива]

## Примеры Code Review комментариев

### Конструктивные примеры:

1. **Проблема:** В ProgressTrackerTest в строке 21 прописано String result = tracker.calculateTotalProgress(mentees);

**Почему это важно:** В тестах передается в метод calculateTotalProgress список (List<Mentee> mentees), 
а сам метод объявлен так, что ждёт массив (Mentee[]). Java не умеет автоматически конвертировать List в массив в таком вызове.

**Предложение:** В ProgressTrackerTest везде, где вызывается calculateTotalProgress(mentees), необходимо заменить передачу списка на преобразование в массив. 
Было: String result = tracker.calculateTotalProgress(mentees); Стало: String result = tracker.calculateTotalProgress(mentees.toArray(new Mentee[0]));

2. **Проблема:** В Student отсутствует фигурная скобка

**Почему это важно:** Из-за отсутствия фигурной скобки код нескомпилируется  

**Предложение:** Необходимо добавить в строке 21 Student фигурную скобку. 

Вывод: в обеих примерах конкретно указана проблема, чем чревато допущение данных ошибок, и подробное решение данной проблемы. 


### Токсичные примеры:

1. **Проблема:** В . github/workflows/ci.yml есть ошибка. Нужно лучше думать.
   **Почему некорректно:** Во-первых нет конкретики (какая именно проблема, где именно).
Во-вторых указание не на саму проблему (код), а на разработчика. 

2. **Проблема:** Код не компилируется. Необходимо переписать. 
   **Почему некорректно:** Опять же, нет конкретики. Необходимо описать проблему, указать 
последствия ее допущения

Вывод: Что в первом, что во втором примере отсутствие конкретики. Указав проблему, ее нахождение, 
почему важно не допускать ее, и как ее решить, это экономит время всех, кто учавствует в проекте.
Так же, это позволит разработчику недопустить в дальнейшем данную ошибку. 

## Результаты само-ревью DVT-9

1. **Проблема:** В . github/workflows/ci.yml в строке 7 стоит 'feature/DVT-8-fix2', 
а должно быть 'feature/**'

**Почему это важно:** если использовать вариант 'feature/DVT-8-fix2', то CI будет запускаться конкретно по данной ветке, остальные он рассматривать не будет.
Если использовать варинат 'feature/**', то CI запустит проверку по всем веткам.
Это критично, во-первых потому что разработчики будут забывать обновлять файл, 
во-вторых в больших проектах очень много feature-веток, и поддерижвать список всех имен в 
ci.yml не возможно

**Предложение:** необходимо заменить 'feature/DVT-8-fix2' на 'feature/**'

2. **Проблема:** В ProgressTracker директория пакета package ru.mentee.power.devtools,
а ProgressTracker имеет путь package ru.mentee.power.devtools.progress  
**Почему это важно:**Структура папок в Packeg должна в точности повторять структуру пакетов.
Это связано с тем, что Javaс и JVM используют файловую систему для поиска .class-файлов.
Когда указывается конкретная директория пакета, компилятор ищет файл по указанному пути, и соответствнно его не находит.
Компиляция не проходит
**Предложение:** Заменить ru.mentee.power.devtools на ru.mentee.power.devtools.progress

3. **Проблема:** В ProgressLoopTest, в строках 14,32,48,56,64 необходимо убрать подчеркивания в именах методов

**Почему это важно:** В checkstyle.xml прописано правило MethodName, которое недопускает данные ошибки. Так же ревьюер сразу попросит переименовать методы с подчёркиваниями. Это лишние итерации и задержка мерджа.
Так же, когда в проекте много похожих методов, единый стиль помогает быстрее понимать, где какой метод. Если кто‑то другой будет править ProgressLoopTest или StudentListTest, ему будет проще ориентироваться.


**Предложение:** Необходимо исправить на примере: Было - shouldCalculateTotalProgress_whenMultipleMentees Стало - shouldCalculateTotalProgressWhenMultipleMentees

## Запросы и источники

| № | Запрос | Операторы | Официальный источник | Альтернатива | Статус | Дата |
|---|--------|-----------|----------------------|--------------|--------|------|
| 1 |Поиск версии Lombok  |site:search.maven.org "lombok |search.maven.org |mvnrepository.com  |200 OK |02.08.2026  |
| 2 |Java Stream API |	site:docs.oracle.com "stream api" intitle:api |docs.oracle.com (Java 17) |docs.oracle.com (Java 11) |200 OK |02.08.2026 |
| 3 |Горячие клавиши IDEA |site:www.jetbrains.com/help "keymap" |jetbrains.com/help |	Help → Keymap Reference (встроенная справка)|200 OK |02.08.2026 |


#### Промпт 1: Проверка кода
Код для проверки:
DeepSeek: (Я написал код для фильтрации студентов по городу.
Вот код:package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentList {
    private final List<Student> students = new ArrayList<>();

    public void addStudent (Student student) {
        students.add(student);
    }

    public int size() {

        return students.size();
    }

    public List<Student> getAll() {

        return new ArrayList<>(students);
    }

    public List<Student> getStudentsByCity(String city) {

        if (city == null || city.isEmpty()) {
            return new ArrayList<>();
        }


        return students.stream()
                .filter(s -> s.getCity() != null && s.getCity().equals(city))
                .collect(Collectors.toList());
    }
}
Проверь на: логические ошибки (граничные случаи, null); Java Code Conventions; производительность.

НЕ переписывай — укажи проблемы и предложи, как исправить.)

Алиса: (Я написал код для фильтрации студентов по городу.
Вот код:package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentList {
    private final List<Student> students = new ArrayList<>();

    public void addStudent (Student student) {
        students.add(student);
    }

    public int size() {

        return students.size();
    }

    public List<Student> getAll() {

        return new ArrayList<>(students);
    }

    public List<Student> getStudentsByCity(String city) {

        if (city == null || city.isEmpty()) {
            return new ArrayList<>();
        }


        return students.stream()
                .filter(s -> s.getCity() != null && s.getCity().equals(city))
                .collect(Collectors.toList());
    }
}
Проверь на: логические ошибки (граничные случаи, null); Java Code Conventions; производительность.

НЕ переписывай — укажи проблемы и предложи, как исправить.)

Сравнение: Так же как и в Плане решения, DeepSeek более конкретизированный. Все по существу, поэтапно, с резюмированием в конце. Алиса выдала ту же информацию, но много текса, который в данном случае только мешает.

#### Промпт 2: План решения
Задача / Контекст / Ограничения / Ожидаемый результат / Критерии успеха

DeepSeek (Задача: Реализовать метод calculateTotalProgress(Mentee[] mentees), который возвращает строку с суммарным прогрессом всех Mentee.
Контекст: Java 25, Gradle 8.8. Есть класс Mentee с полями completedLessons и totalLessons.
Ограничения: нельзя использовать сторонние библиотеки для форматирования строк.
Что нужно: план из 3-5 шагов с объяснением «почему» и какие граничные случаи учесть. НЕ пиши код — реализую сам.
Критерии успеха: метод должен корректно работать для пустого массива, массива из 1 и из 10+ Mentee.)

Алиса: (Задача: Реализовать метод calculateTotalProgress(Mentee[] mentees), который возвращает строку с суммарным прогрессом всех Mentee.
Контекст: Java 25, Gradle 8.8. Есть класс Mentee с полями completedLessons и totalLessons.
Ограничения: нельзя использовать сторонние библиотеки для форматирования строк.
Что нужно: план из 3-5 шагов с объяснением «почему» и какие граничные случаи учесть. НЕ пиши код — реализую сам.
Критерии успеха: метод должен корректно работать для пустого массива, массива из 1 и из 10+ Mentee.)

Сравнение: Использовав два ассиестента (DeepSeek и Алиса)нашел два различия. В DeepSeek ответы более конкретизированные. В целом и тот и тот ассистент предоставили подробные ответы. На примере данного запроса, мне кажется что тут дело вкуса. Алиса выдает сначало много
текста, как бы вводит тебя в курс происходящего, впоследствии переходя к сути. DeepSeek же, как и написал выше, более конкретен в своем ответе. Все описано по пунктно, нет воды.
Если опираться на свой опыт использования двух ассистентов (а именно их я использовал при прохождении 3 Спринтов), то в последнее время предпочтения отдаю больше DeepSeek, из-за его конкретики и минимум текса. Все по существу.

## Личный глоссарий терминов Dev Tools 

### Категория: Java-экосистема
#### JDK — Java Development Kit
**Определение:** Development environment for building Java applications; includes javac, jar, javadoc.
**Контекст:** нужен для компиляции кода в байт-код и сборки проекта.
**Пример:** java -version проверяет версию; в IDEA Project SDK указывает на установленный JDK.
**Источник:** https://docs.oracle.com/en/java/javase/

#### JRE — Java Runtime Environment
**Определение:** The JRE provides the libraries, Java virtual machine, 
and other components necessary for you to run applets and applications written in the Java programming language. 
This runtime environment can be redistributed with applications to make them free-standing.
**Контекст:** JRE предоставляет библиотеки, виртуальную машину Java и другие компоненты, необходимые для запуска апплетов и приложений, написанных на языке Java
**Пример:** java -jar app.jar --config config.xml
**Источник:** https://docs.oracle.com/javase/8/docs/technotes/guides/

#### JVM - Java Virtual Machine
**Определение:** This is the foundation of the Java runtime environment. The JVM loads, verifies, and executes the application and library code.
**Контекст:** Нажимая кнопку RUN, IDEA запускает код в отдельном процессе JVM. Так же обеспечивает работу редактора, проверки кода, автодополнения и всех остальных функций
**Пример:** Запуск происходит через команду 'java', загружает указанный класс, находит в нем метод 'main' и запускает его выполнение.
**Источник** https://docs.oracle.com/javase/jp/8/embedded/develop-apps-platforms/embedded-jvms.htm#CHDCHECF

#### JAR - Java ARchive - Архив Java
**Определение:** It's a file format based on the popular ZIP file format and is used for aggregating many files into one.
**Контекст:** При использовании сторонней библиотеки, чтобы получить готовый для передачи файл, чтобы протестировать готовое приложение или запустить его на сервере.
**Пример:** Build → Build Artifacts → Build; Run → Edit Configurations → + → JAR Application.
**Источник** https://docs.oracle.com/javase/8/docs/technotes/guides/jar/jarGuide.html

### Категория: Инструменты разработки 
#### Pull Request - Запрос на слияние
**Определение:** A pull request is a proposal to merge a set of changes from one branch into another.
**Контекст:** Code Review, обучение и обмен знаниями, прозрачность и аудит. 
**Пример:** 'git push origin *имя ветки* - Compare & pull request'
**Источник** https://docs.github.com/en/enterprise-server@3.13/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests

#### Gradle Wrapper - Gradle Wrapper
**Определение:** The recommended way to run any Gradle build.
**Контекст:** Стандартизация (Проект всегда собирается с одной и той же версией Gradle, 
независимо от того, у кого на компьютере запускается сборка), Простота настройки (Чтобы начать работать с проектом, 
новому разработчику не нужно вручную устанавливать Gradle — достаточно склонировать репозиторий и запустить './gradlew'),
Гибкость обновления (Сменить версию Gradle для всего проекта можно простым изменением одной строчки в файле 'gradle/wrapper/gradle-wrapper.properties')
**Пример:** ./gradlew build
**Источник** https://docs.gradle.org/current/userguide/gradle_wrapper.html

#### Branch - Ветка
**Определение:** A pointer (reference) to a specific commit.
**Контекст:** Чтобы работать над новой функцией, не мешая стабильному коду в основной ветке (обычно master или main)
**Пример:** 'git checkout -b feature/*имя ветки*' - создает новую ветку и переключается на нее.
**Источник** https://docs.gradle.org/current/userguide/gradle_wrapper.html

#### Git - Git 
**Определение:** Distributed version control system
**Контекст:** позволяет отслеживать изменения в любых файлах, 
координировать работу нескольких разработчиков и сохранять полную историю проекта
**Пример:** 'git status' - показывает текущее состояние файлов; 'git fetch' - загружает новые данные, но не удаляет ссылки на удалённые ветки;
'git remote prune origin' - удаляет локальные ссылки на удалённые ветки, которых нет на сервере
**Источник** https://git-scm.com/?utm_campaign=programador-junior-python-en-madrid

#### Checkstyle - Checkstyle
**Определение:** A development tool that helps programmers write Java code that complies with the coding standard.
**Контекст:** Он автоматизирует процесс проверки Java-кода, избавляя разработчиков от этой рутинной (но важной) задачи
**Пример:** './gradlew checkstyleMain' - проверка основного кода; './gradlew checkstyleTest' - проверка тестов;
'./gradlew checkstyleMain checkstyleTest' - проверка всего кода.
**Источник** https://checkstyle.sourceforge.io/version/10.21.1/summary.html#Project_Summary

#### Commit - Commit
**Определение:** It’s like “saving” your work, but with powerful features for tracking history.
**Контекст:** Создание "точек сохранения", формирование истории, основа для совместной работы
**Пример:** 'git commit -m "feat: реализация *имя ветки*' - запись изменений в репозиторий
**Источник** https://git.github.io/htmldocs/git-commit.html

#### Debug - Debug
**Определение:** The process of identifying, isolating, and fixing errors (bugs) in the software code.
**Контекст:** Где: Локальная отладка приложений, Отладка тестов; 
Зачем: Останавливать выполнение в нужный момент (Breakpoints); Управлять выполнением по шагам (Stepping).
**Пример:** ПКМ на main → Debug 'нужный class'
**Источник** https://learn.microsoft.com/en-ca/visualstudio/debugger/what-is-debugging?view=vs-2022

### Категория: Процессы и практики
#### Code Review - Проверка кода
**Определение:** A systematic review of the source code to improve its quality, identify errors, 
and ensure that the code complies with the project’s standards and requirements.
**Контекст:** Поиск ошибок и улучшение качества, Обучение и обмен знаниями, Обеспечение единых стандартов,
Улучшение совместной работы.
**Пример:** В PR комментарий от ревьюера
**Источник** https://www.reviewboard.org/docs/manual/5.0/users/getting-started/what-is-code-review/

#### Self-Review - Саморецензирование
**Определение:** The process in which the code author independently checks their changes 
before sending them for review by colleagues or merging them into the main branch.
**Контекст:** Цель - поймать очевидные ошибки до того, как на них потратят время другие разработчики
**Пример:** './gradlew checkstyleMain test' - проверяет качество кода; 
'git status' - показать текущее состояние рабочего каталога и индекса.
**Источник** https://github.com/etak-ai/etak/blob/main/deliver/skills/review/SKILL.md

#### Runbook - Runbook
**Определение:** This is a documented process for achieving
**Контекст:** Снижение рисков и человеческого фактора, стандартизация и обучение, автоматизация и скорость.
**Пример:** Run/Debug Configurations и Startup Tasks
**Источник** https://www.cortex.io/post/keep-calm-and-use-the-runbook

#### Checkpoint - Checkpoint
**Определение:** Saving the system state at a specific point in time to enable recovery.
**Контекст:** В Git это может быть как личная практика частых коммитов, 
так и техническая команда в fast-import для защиты от сбоев при импорте больших данных.
**Пример:** Local History, Labels
**Источник** https://qwenlm.github.io/qwen-code-docs/de/users/features/checkpointing/#aktivieren-der-funktion

### Вопросы по сложным терминам
### Вопрос N 1: Terminal
**Задача:** Понять как работает во всей системе IDEA, как он взаимодействует со всеми командами в Terminal
**Контекст:** Встретил при прохождении заданий, от напиании кода, до push в github.
Изучил различные команды.
**Ограничения:** Проверок статусов, удаления файлов, перемещения на удаленный репозиторий и т.д.
**Ожидаемый результат:** Это как командная строка прямо внутри проекта — вместо того, 
чтобы открывать отдельное окно cmd или терминал, нужно нажать Alt+F12 и получить доступ к консоли, которая уже находится в папке с кодом.
Terminal нужен, чтобы быстро:
- Запускать Gradle, Maven или другие команды для сборки приложения.
- Работать с Git (делать commit, push, pull), если удобнее через команды, а не через кнопки.
- Выполнять любые системные команды, например, проверить версию Java или переименовать файл, не переключаясь между окнами.
**Критерии успеха:** Разобрался в целом для чего используется Terminal, так же добавил себе шпаргалку по актуальным командам.

### Вопрос N 2: Breakpoint
**Задача:** Как правильно им пользоваться, для чего он нужен
**Контекст:** При поиске ошибки в коде
**Ограничения:** Ставил маркер в коде, чтобы приостановить выполнение программы в нужном месте и изучть что происходит внутри.
**Ожидаемый результат:** Это главный инструмент отладчика в IntelliJ IDEA, позволяющий «заглянуть» в работающую программу и найти ошибку.
**Критерии успеха:** Нужно поставить точку в нужной мне строке кода, далее нажать Debug или Shift+F9.
Программа запустится и остановится на первой же строке, где я поставил Breakpoint.


