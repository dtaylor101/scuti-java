
var webSocket = new WebSocket("ws://localhost:4567/chat");
webSocket.onclose = function () { alert("WebSocket connection closed") };

