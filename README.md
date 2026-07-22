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
1. Открой Gradle Tool Window (`View → Tool Windows → Gradle`).
2. Выполни: `devtools → Tasks → application → run`. (Если выдает ошибку (ссылается на другой файл),попробуй напроти public static.. нажать Run)
3. В Run Tool Window должен быть вывод:
   Executing ':examples.devtools.ru.mentee.power.ProgressTracker.main()'…

> Task :compileJava UP-TO-DATE
> Task :processResources NO-SOURCE
> Task :classes UP-TO-DATE

> Task :examples.devtools.ru.mentee.power.ProgressTracker.main()
��������: �������� 25 �� 36 ������, �������� 11 ������

BUILD SUCCESSFUL in 447ms
2 actionable tasks: 1 executed, 1 up-to-date
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.3.0/userguide/configuration_cache_enabling.html
23:55:26: Execution finished ':examples.devtools.ru.mentee.power.ProgressTracker.main()'.
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

Проверка DVT‑6

1. Открыть `ProgressTracker.java`, поставить breakpoint на строку внутри цикла `while`.
2. Запустить в режиме Debug (значок 🐞 рядом с `main`).
3. В момент остановки открыть Evaluate Expression (Alt+F8) и проверить выражение `mentees[0]`.
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
После public int size(){
Почему: Повышает читаемость кода
https://checkstyle.org/checks/whitespace/whitespacearound.html


## Быстрая проверка

Выполни в терминале:
```bash
./gradlew checkstyleMain 
./gradlew test
./gradlew jacocoTestCoverageVerification