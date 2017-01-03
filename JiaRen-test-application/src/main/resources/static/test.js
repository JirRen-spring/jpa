var converter = new showdown.Converter();
var myCodeMirror = CodeMirror.fromTextArea(document.getElementById("text-area"), {
    lineNumbers: true,
    value: "function myScript(){return 100;}\n",
	mode:  "markdown"
})
	
myCodeMirror.on("change", function(CodeMirror, changeObj){
	CodeMirror.save();
	var html = converter.makeHtml(document.getElementById("text-area").value);
	var showMarkdown = document.getElementById("show-markdown");
	showMarkdown.innerHTML = html;
});






//  var editor = CodeMirror.fromTextArea(document.getElementById("text-area"), {
//    lineNumbers: true,
//    styleActiveLine: true,
//    matchBrackets: true
//  });
//  var input = document.getElementById("select");
//  function selectTheme() {
//    var theme = input.options[input.selectedIndex].textContent;
//    editor.setOption("theme", theme);
//    location.hash = "#" + theme;
//  }
//  var choice = (location.hash && location.hash.slice(1)) ||
//               (document.location.search &&
//                decodeURIComponent(document.location.search.slice(1)));
//  if (choice) {
//    input.value = choice;
//    editor.setOption("theme", choice);
//  }
//  CodeMirror.on(window, "hashchange", function() {
//    var theme = location.hash.slice(1);
//    if (theme) { input.value = theme; selectTheme(); }
//  });
