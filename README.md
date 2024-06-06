Автор - Мельников Никита Сергеевич
<h2>Конфигурация приложения</h2>
Конфигураци приложения происходит в файле application.properties. В нем необходимо указать следующие параметры:<br>
vk.api.token - токен бота.
vk.group.id - id группы ВК.
vk.api.version - версия API.
vk.confirmation.code - код для подтверждения сервера.
server.port - порт, на котором будет работать сервер.
<h2>Запуск приложения</h2>
Для запуска приложения необходимо проделать следующие шаги:<br>
1) Перейти корневую папку проекта <i>(cd VkEchoBot/)</i>;
2) Запустить приложение командой <i>mvn spring-boot:run</i>;
3) Запустить ngrok командой <i>ngrok http 8080</i> (вместо 8080 нужно указать порт, заданный в конфигурации в параметре <b>server.port</b>);
4) Указать полученный от ngrok URL адрес в разделе настроек сервера callback API в ВК и в конце URL добавить /callback. (Например: https://aaaa-11-222-33-44.ngrok-free.app<b>/callback</b>)
5) Нажать на кнопку подтвердить, чтобы сервер отправил vkAPI код подтверждения.
Готово! После этого бот должен корректно работать и отправлять пользователю его же сообщения.