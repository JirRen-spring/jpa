var converter = new showdown.Converter();
var text      = '#hello, markdown!';
var html      = converter.makeHtml(text);
var showMarkdown = document.getElementById("show-markdown");
showMarkdown.innerHTML = html;