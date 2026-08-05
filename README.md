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
```bash
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


## Информационный поиск — результаты DVT-11

### Запросы и источники

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

1. Логические ошибки и граничные случаи
Проблема 1.1: Чувствительность к регистру
Где: s.getCity().equals(city)
В чём проблема: Сравнение equals чувствительно к регистру. Если в массиве город написан с большой буквы ("Moscow"), а пользователь ищет с маленькой ("moscow"), студент не найдётся. Это частая причина багов.

Как исправить: Используйте equalsIgnoreCase() вместо equals(). Это сделает поиск регистронезависимым.

java
.filter(s -> s.getCity() != null && s.getCity().equalsIgnoreCase(city))
Проблема 1.2: Возврат нового ArrayList при null или пустой строке
Где: if (city == null || city.isEmpty()) { return new ArrayList<>(); }
В чём проблема: Это работает, но создаёт новый объект каждый раз. Для метода, который вызывается часто, это лишние накладные расходы.

Как исправить: Возвращать Collections.emptyList() — это иммутабельный пустой список, который не создаёт новый объект при каждом вызове.

java
if (city == null || city.isEmpty()) {
    return Collections.emptyList();
}
Не забудьте импортировать java.util.Collections.

Проблема 1.3: Обработка null для всего массива students
Где: private final List<Student> students = new ArrayList<>();
В чём проблема: Поле students инициализируется при создании объекта, поэтому null для списка не грозит. Это хорошо. Но если в списке окажется null-элемент (например, кто-то добавил null через addStudent(null)), то код упадёт на s.getCity().

Как исправить: Добавить защиту от null-элементов в самом начале стрима:

java
return students.stream()
        .filter(s -> s != null && s.getCity() != null && s.getCity().equalsIgnoreCase(city))
        .collect(Collectors.toList());
Или, что правильнее, запретить добавление null в методе addStudent:

java
public void addStudent(Student student) {
    if (student == null) {
        throw new IllegalArgumentException("Student cannot be null");
    }
    students.add(student);
}
2. Java Code Conventions (Google/Java Style Guide)
Проблема 2.1: Лишние пустые строки
Где:

public void addStudent (Student student) { — пробел перед ( лишний.

После size() { и getAll() { есть пустые строки, а в getStudentsByCity — лишняя пустая строка перед return.

Как исправить:

Убрать пробел перед (: public void addStudent(Student student) {

Убрать лишние пустые строки внутри методов. Тело метода должно начинаться сразу после {, без пустой строки.

Проблема 2.2: Порядок модификаторов
Всё в порядке: public идёт первым, затем final.

3. Производительность
Проблема 3.1: Collectors.toList() возвращает ArrayList
В чём проблема: Это нормально, но если метод вызывается очень часто, создание нового списка каждый раз — накладные расходы.

Как исправить: В данном случае это не критично, так как список фильтруется и возвращается. Но если производительность важна, можно вернуть List.copyOf() (если нужна защита от изменений):

java
return students.stream()
        .filter(...)
        .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
Но это уже избыточно для вашей задачи.

4. Дополнительные рекомендации
Рекомендация 4.1: Имя метода
getStudentsByCity — хорошее имя. Оно понятно и соответствует тому, что делает метод.

Рекомендация 4.2: Проверка city на null
Сделана корректно, но можно объединить с проверкой на null внутри стрима.

📋 Итоговый список того, что стоит поправить
Проблема	Где	Как исправить
Чувствительность к регистру	filter(s -> ... equals(city))	Заменить на equalsIgnoreCase
Создание нового ArrayList на каждый вызов	return new ArrayList<>();	Заменить на Collections.emptyList()
Защита от null в addStudent	Метод не проверяет аргумент	Добавить проверку и выброс исключения
Лишний пробел в addStudent (Student	addStudent (Student	Убрать пробел: addStudent(Student
Лишние пустые строки в теле методов	После { в size(), getAll(), getStudentsByCity	Убрать пустые строки

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

Логические ошибки и граничные случаи
Чувствительность к регистру в сравнении городов. Сейчас s.getCity().equals(city) сработает только при точном совпадении регистра (например, «Москва» ≠ «москва»). Это частая логическая проблема в фильтрах.
Как исправить: использовать equalsIgnoreCase либо заранее нормализовать город (например, city = city.trim().toLowerCase()), но тогда и в объектах студентов город тоже должен быть нормализован. Вариант:

java
String normalizedCity = city.trim();
return students.stream()
    .filter(s -> s.getCity() != null && s.getCity().equals(normalizedCity))
    .collect(Collectors.toList());
или, если нужна нечувствительность к регистру:

java
return students.stream()
    .filter(s -> s.getCity() != null && s.getCity().equalsIgnoreCase(city.trim()))
    .collect(Collectors.toList());
Обработка пробелов. Если в city есть лишние пробелы (например, " Москва "), фильтр не найдёт совпадения.
Как исправить: обрезать пробелы через trim() перед проверкой: city.trim().

Пустая строка после trim. Если передать строку из одних пробелов, после trim() она станет пустой. Текущая проверка city.isEmpty() это поймает, но лучше делать trim() до проверки, чтобы покрыть этот случай явно.
Как исправить:

java
if (city == null) {
    return new ArrayList<>();
}
String trimmedCity = city.trim();
if (trimmedCity.isEmpty()) {
    return new ArrayList<>();
}
Java Code Conventions
Пробелы вокруг фигурных скобок и после ключевых слов. В коде есть лишние пустые строки внутри методов и неравномерные отступы/пробелы. По conventions (и по Checkstyle, с которым ты работал) нужно:

Убрать лишние пустые строки внутри метода.
Писать public void addStudent(Student student) (без пробела перед скобкой).
Единообразно форматировать: { на той же строке, один пробел после ключевых слов.
Пример исправленного стиля для addStudent:

java
public void addStudent(Student student) {
    students.add(student);
}
Именование: addStudent — корректно, getStudentsByCity — корректно. StudentList — допустимо, но если это не коллекция-обёртка, а бизнес-объект, иногда выбирают имена вроде StudentRegistry или StudentService. Это не ошибка, а вопрос согласованности в твоём проекте (в твоём репозитории devtools можно придерживаться текущего стиля, если он везде такой).

Производительность
Создание нового ArrayList в getAll() — это правильно (защита инкапсуляции), но стоит помнить, что это O(n) по памяти и времени. Для твоего случая (простой список студентов) это нормально.
Stream в getStudentsByCity — для небольших и средних списков это нормально и читаемо. Если список станет очень большим и метод будет вызываться часто, можно подумать о предварительной индексации (например, Map<String, List<Student>> по городам). Но для текущей задачи преждевременная оптимизация не нужна.
.collect(Collectors.toList()): в Java 10+ можно использовать Collectors.toUnmodifiableList(), если не нужно дальше менять результат. Это даёт дополнительную защиту от случайных изменений.
Пример:
java
.collect(Collectors.toUnmodifiableList());
Дополнительные замечания в контексте твоего проекта
Учитывая, что ты работаешь с Checkstyle и JaCoCo в репозитории devtools, обрати внимание:

Checkstyle может ругаться на лишние пустые строки и форматирование — лучше привести код к единому стилю (можно использовать автоформат в IntelliJ IDEA).
Для покрытия тестами (JaCoCo) важно покрыть граничные случаи: null город, пустая строка, город с пробелами, город, которого нет, и город, у которого есть совпадения. Это повысит покрытие и снизит риск ошибок в CI.

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

План решения (3 шага)
Шаг 1. Проверка входных данных (защита от null и пустого массива)
Проверить, что массив mentees не равен null.

Проверить, что массив не пустой (length == 0).

Почему:
Это базовый контракт метода. Без этой проверки код упадёт с NullPointerException или с ошибкой при обращении к элементам. В реальном коде такие ошибки часто всплывают в самом неудобном месте, поэтому защита должна быть на входе.

Граничный случай:

Массив null → выбросить IllegalArgumentException с понятным сообщением.

Пустой массив → вернуть специальное сообщение, например: "Нет данных для расчёта".

Шаг 2. Суммирование полей completedLessons и totalLessons по всем элементам массива
Пройти по массиву в цикле (или через Stream, если разрешено).

Для каждого Mentee:

Проверить, что объект не null (защита от неожиданных данных).

Суммировать completedLessons в переменную totalCompleted.

Суммировать totalLessons в переменную totalTotal.

Почему:
Суммирование — единственный способ получить общий прогресс. Использовать Stream или обычный цикл — вопрос вкуса, но важно, чтобы суммирование было защищённым от null-элементов, чтобы не упасть в процессе.

Граничный случай:

Если в массиве есть null-элемент → пропустить его (или выбросить исключение — зависит от контракта).
Рекомендация: выбрасывать исключение, чтобы не скрывать ошибки в данных.

Шаг 3. Формирование итоговой строки
Вычислить remaining = totalTotal - totalCompleted.

Сформировать строку по шаблону:
"Суммарно: пройдено {totalCompleted} из {totalTotal} уроков, осталось {remaining} уроков".

Почему:
Форматирование должно быть единообразным. Сторонние библиотеки запрещены, поэтому используем стандартную конкатенацию или String.format (это часть Java, не сторонняя библиотека). String.format предпочтительнее, так как улучшает читаемость и упрощает поддержку.

Граничный случай:

Если totalTotal == 0 (теоретически возможно, если все Mentee имеют totalLessons == 0):
нужно решить, что выводить — деление на ноль не должно возникнуть, но сообщение должно быть осмысленным (например, "Все курсы нулевой длины").

Дополнительные граничные случаи (для самостоятельной проверки)
Сценарий	Ожидаемое поведение
Массив null	Выброс исключения
Пустой массив	Сообщение: "Нет данных для расчёта"
Элементы массива null	Выброс исключения с указанием индекса
completedLessons > totalLessons у одного из Mentee	Можно предупредить или выбросить исключение (зависит от контракта)
Отрицательные значения полей	Выброс исключения
Массив с 10+ элементами	Формирование строки без потери производительности (цикл O(n))
totalLessons == 0 у всех	Вывод: "пройдено 0 из 0 уроков" (без деления)
Критерии успеха (как проверить)
Корректность:
Для массива из 3 Mentee с разными данными результат содержит правильные суммы и остаток.

Обработка краев:

Пустой массив → специальное сообщение.

Массив с null → исключение.

Все значения корректны (нет отрицательных или превышающих totalLessons).

Читаемость:
Строка форматируется одинаково для любого размера массива.

Производительность:
Метод работает за O(n) и не создаёт тяжёлых объектов в цикле.

Алиса: (Задача: Реализовать метод calculateTotalProgress(Mentee[] mentees), который возвращает строку с суммарным прогрессом всех Mentee.
Контекст: Java 25, Gradle 8.8. Есть класс Mentee с полями completedLessons и totalLessons.
Ограничения: нельзя использовать сторонние библиотеки для форматирования строк.
Что нужно: план из 3-5 шагов с объяснением «почему» и какие граничные случаи учесть. НЕ пиши код — реализую сам.
Критерии успеха: метод должен корректно работать для пустого массива, массива из 1 и из 10+ Mentee.)

Шаг 1. Обработать null‑массив
Что сделать: сразу проверить, если mentees == null, вернуть осмысленное значение (чаще всего пустую строку или строку вроде "0%" — зависит от требований задачи).
Почему: это предотвращает NullPointerException и делает метод устойчивым к некорректному вызову. В твоём репозитории devtools это критично: тесты и CI могут передавать неожиданные значения, и падение метода даст BUILD FAILED.
Граничный случай: mentees = null.

Шаг 2. Обработать пустой массив
Что сделать: если mentees.length == 0, вернуть строку, соответствующую «нет данных» (например, "0%" или "No mentees" — опять же, по требованиям задачи).
Почему: пустой массив — валидное состояние, и метод не должен падать. Это отдельный кейс для тестов: он нужен, чтобы поднять покрытие JaCoCo и пройти Self‑review/ревью.
Граничные случаи:

пустой массив (new Mentee[0]);
массив с нулевыми элементами внутри (см. шаг 3).
Шаг 3. Пройти по массиву и накопить два числа: totalCompleted и totalLessons
Что сделать: в цикле (или стриме, если это не запрещено ограничениями) просуммировать completedLessons и totalLessons по всем не‑null элементам. Если какой‑то Mentee внутри массива равен null, его нужно пропустить (или обработать по ТЗ).
Почему: прогресс считается по совокупности всех учеников, а не как среднее арифметическое процентов. Правильная формула:
overallProgress = totalCompleted / totalLessons * 100.
Если считать среднее процентов — результат будет искажён.
Граничные случаи:

в массиве есть null элементы (например, new Mentee[]{null, m1, null, m2});
все элементы null;
у отдельных Mentee поля могут быть отрицательными или нулевыми (если это не запрещено контрактом класса).
Шаг 4. Обработать случай «нет уроков вообще» (деление на ноль)
Что сделать: проверить, если totalLessons == 0. Тогда нельзя делить — нужно вернуть заранее определённое значение (часто "0%" или "N/A").
Почему: деление на ноль вызовет ошибку или невалидный результат. В Java целочисленное деление на 0 выбрасывает ArithmeticException, а в дробном даст Infinity/NaN. Это частая причина падающих тестов и красных чеков в CI.
Граничные случаи:

totalLessons = 0 при любом totalCompleted (в том числе 0);
отрицательные значения (если они возможны) — их тоже нужно валидировать или трактовать как ошибку.
Шаг 5. Вычислить процент и отформатировать строку без сторонних библиотек
Что сделать: вычислить процент, округлить по правилам задачи и превратить в строку, используя только стандартные средства Java (например, String.format, конкатенацию, StringBuilder).
Почему: ограничение «без сторонних библиотек» означает, что нельзя подключать дополнительные зависимости в build.gradle и использовать внешние утилиты форматирования. При этом String.format и стандартные классы — допустимы. Важно, чтобы формат был предсказуемым для тестов (например, ровно один знак после запятой или целое число).
Граничные случаи:

результат ровно 0%, 100%;
дробные значения, требующие округления (например, 33.333…%);
очень большие числа, если поля int могут переполниться при суммировании (в таком случае лучше использовать long для аккумуляторов).
Какие граничные случаи учесть для покрытия тестами (JaCoCo) и ревью
Учитывая твой стек (Gradle, JaCoCo, Checkstyle) и работу с PR/CI, в тестах стоит явно покрыть:

null массив;
пустой массив;
массив из 1 элемента;
массив из 10+ элементов;
элементы с completedLessons = 0;
элементы с totalLessons = 0;
комбинация, где totalLessons = 0 по всему массиву;
наличие null элементов внутри массива;
случаи, где суммарный прогресс ровно 0% и ровно 100%.
Это закроет требования к корректности и даст высокий процент покрытия, а также поможет пройти ревью без замечаний по граничным случаям. Если скажешь, какой формат строки нужен (например, "57%" или "Progress: 57.3%"), подскажу, как лучше округлять и форматировать.

Сравнение: Использовав два ассиестента (DeepSeek и Алиса)нашел два различия. В DeepSeek ответы более конкретизированные. В целом и тот и тот ассистент предоставили подробные ответы. На примере данного запроса, мне кажется что тут дело вкуса. Алиса выдает сначало много
текста, как бы вводит тебя в курс происходящего, впоследствии переходя к сути. DeepSeek же, как и написал выше, более конкретен в своем ответе. Все описано по пунктно, нет воды.
Если опираться на свой опыт использования двух ассистентов (а именно их я использовал при прохождении 3 Спринтов), то в последнее время предпочтения отдаю больше DeepSeek, из-за его конкретики и минимум текса. Все по существу.


