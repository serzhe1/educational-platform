INSERT INTO users (username, full_name)
VALUES ('owner1', 'Иванов Иван Иванович');

INSERT INTO courses ("name", description, format, requirements, competencies, owner_id)
VALUES ('Программирование и разработка веб-приложений.',
        'Данный онлайн-курс посвящен изучению программирования на языке Python и является логичным продолжением курса «Программирование и разработка веб-приложений».',
        'В состав курса входят видеолекции с опросами, упражнения, тесты, дополнительные материалы в виде презентаций по темам. Длительность курса составляет 10 недель. Трудоемкость курса – 3 зачетных единицы. Средняя недельная нагрузка на обучающегося – 10 часов.',
        'Для успешного освоения курса необходимо знание основ программирования, HTML, Интернет-технологий. Плюс курс «Программирование и разработка веб-приложений».',
        'Способность применять знания программирования для хранения данных (РО-1). Способность применять знания программирования для обработки данных (РО-2). Способность применять знания программирования для решения задач по созданию веб-приложений (РО-3)',
        1);

INSERT INTO modules (name, description, course_id)
VALUES ('Использование регулярных выражений',
        'В этом модуле вы научитесь использовать регулярные выражения в Python для поиска и обработки текстовой информации. Вы узнаете, как составлять регулярные выражения, как применять их для поиска и замены текста, а также научитесь использовать различные функции и методы для работы с регулярными выражениями.',
        1),
       ('Скрапинг с испрользованием BeautifulSoup',
        'В этом модуле вы научитесь использовать библиотеку BeautifulSoup для скрапинга веб-страниц. Вы узнаете, как парсить HTML-код страницы, как находить нужные элементы на странице и как извлекать нужную информацию. Также вы научитесь работать с различными атрибутами элементов, получать содержимое тегов и многое другое.',
        1),
       ('Многопоточные и многопроцессорные возможности Python',
        'В этом модуле вы научитесь использовать возможности Python для многопоточного и многопроцессорного программирования. Вы узнаете, как создавать и управлять потоками и процессами, как синхронизировать доступ к ресурсам и как решать проблемы, связанные с многопоточностью и многопроцессорностью.',
        1),
       ('Работа с реляционными базами данных (SQLite, MySQL, PostgeSQL)',
        'В этом модуле вы научитесь работать с реляционными базами данных в Python, включая SQLite, MySQL и PostgreSQL. Вы узнаете, как создавать и управлять базами данных, как выполнять запросы к базе данных с помощью языка SQL и как работать с результатами запросов. Также вы узнаете, как использовать Python для автоматизации работы с базами данных и как защищать базы данных от несанкционированного доступа.',
        1),
       ('Работа с не реляционными базами данных (MongoDB)',
        'В этом модуле вы научитесь работать с нереляционными базами данных в Python, включая MongoDB. Вы узнаете, как создавать и управлять базами данных, как выполнять запросы к базе данных и как работать с результатами запросов. Также вы узнаете, как использовать Python для автоматизации работы с базами данных и как защищать базы данных от несанкционированного доступа.',
        1);

INSERT INTO lectures (name, content, module_id)
VALUES ('Введение в регулярные выражения и их синтаксис', '# **Введение в регулярные выражения и их синтаксис**

Регулярные выражения (Regular Expressions, или просто Regex) - это синтаксис для поиска и обработки текста. Они используются в различных языках программирования, в текстовых редакторах и утилитах командной строки.

Regex состоят из символов, которые описывают шаблон, который нужно найти в тексте. К примеру, вы можете использовать регулярные выражения для поиска всех email адресов в текстовом документе или для поиска всех слов, начинающихся на определенную букву.

Символы регулярных выражений используются для задания шаблона поиска. Некоторые из самых распространенных символов включают:

- **`.`**: соответствует любому одиночному символу, кроме перевода строки
- **``**: соответствует 0 или более повторений предыдущего символа
- **`+`**: соответствует 1 или более повторений предыдущего символа
- **`?`**: соответствует 0 или 1 повторению предыдущего символа
- **`|`**: соответствует одному из двух символов, разделенных вертикальной чертой
- [ ]  **`[ ]`**: соответствует любому одному символу внутри квадратных скобок
- **`^`**: соответствует началу строки
- **`$`**: соответствует концу строки

Существует много других символов и комбинаций, которые можно использовать в регулярных выражениях. Изучение регулярных выражений может быть сложным и требовательным, но они могут быть очень полезными при работе с текстом.',
        1),
       ('Применение регулярных выражений для поиска и обработки текста', 'Variables and data types', 1),
       ('Основы парсинга и веб-скрапинга в Python', 'Business writing structure', 2),
       ('Использование библиотеки BeautifulSoup для сбора данных с веб-страниц', 'Control structures', 2),
       ('Понимание основ многопоточности и многопроцессорности в Python', 'Functions and arrays', 3),
       ('Оптимизация производительности приложений с помощью многопоточности и многопроцессорности', 'Verbs and tenses',
        3),
       ('Основы реляционных баз данных и SQL-запросов', 'Nouns and pronouns', 4),
       ('Работа с реляционными базами данных на примере SQLite, MySQL и PostgreSQL', 'Email writing', 4),
       ('Введение в нереляционные базы данных и MongoDB', 'Business writing structure', 5),
       ('Применение MongoDB для обработки больших объемов данных', 'Email writing', 5);

INSERT INTO tests (question, module_id)
VALUES ('Для чего используется символ точки (.) в регулярных выражениях?', 1),
       ('Какова цель знака плюса (+) в регулярных выражениях?', 1),
       ('Что такое lookaround в регулярных выражениях?', 1),
       ('Как можно использовать регулярные выражения для проверки адреса электронной почты?', 1);

INSERT INTO test_answers (answer, is_right, test_id)
VALUES ('Именованный контейнер для значения, которое можно изменить', true, 1),
       ('Именованный контейнер для значения, которое нельзя изменить', false, 1),
       ('Тип данных, представляющий одно значение', false, 1),
       ('Тип данных, представляющий несколько значений', false, 1);

INSERT INTO test_answers (answer, is_right, test_id)
VALUES ('Знак плюса соответствует одному или нескольким повторяющимся символам, предшествующим ему', true, 2),
       ('Знак плюса соответствует нулю или нескольким повторяющимся символам, предшествующим ему', false, 2),
       ('Знак плюса соответствует только одному символу, предшествующему ему', false, 2),
       ('Знак плюса соответствует одному или нескольким повторяющимся символам из любого количества символов', false, 2);

INSERT INTO test_answers (answer, is_right, test_id)
VALUES ('Lookaround - это нулевая ширина утверждение, которое соответствует определенному образцу, не включая его в результат сопоставления', true, 3),
       ('Lookaround - это тип квантификатора, который определяет, сколько раз должен совпадать образец', false, 3),
       ('Lookaround - это символ, который соответствует любому символу, кроме перевода строки', false, 3),
       ('Lookaround - это сокращенная запись для указания диапазона символов, которые нужно найти', false, 3);

INSERT INTO test_answers (answer, is_right, test_id)
VALUES ('Регулярные выражения могут быть использованы для сопоставления синтаксиса адреса электронной почты, но не для проверки, что он является действительным адресом электронной почты', false, 4),
       ('Регулярные выражения могут быть использованы для проверки, что адрес электронной почты соответствует стандартному формату, включая наличие символа "@" и доменной части', true, 4),
       ('Регулярные выражения не могут быть использованы для проверки адреса электронной почты', false, 4),
       ('Регулярные выражения могут быть использованы только для проверки наличия символа "@" в адресе электронной почты', false, 4);