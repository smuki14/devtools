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

## Checkstyle: подтверждение severity=error и severity=warning

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