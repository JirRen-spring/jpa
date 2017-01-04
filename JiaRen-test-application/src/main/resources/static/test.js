var converter = new showdown.Converter();
showdown.setFlavor('github');
//converter.setFlavor('github');
//converter.setOption('noHeaderId', true);
//converter.setOption('ghCompatibleHeaderId', true);
//converter.setOption('prefixHeaderId', true);
//converter.setOption('simplifiedAutoLink', true);
//converter.setOption('excludeTrailingPunctuationFromURLs', true);
//converter.setOption('literalMidWordUnderscores', true);
//converter.setOption('strikethrough', true);
//converter.setOption('tables', true);
//converter.setOption('tablesHeaderId', true);
//converter.setOption('tasklists', true);
//converter.setOption('smoothLivePreview', true);
//converter.setOption('disableForced4SpacesIndentedSublists', true);
//converter.setOption('simpleLineBreaks', true);
//converter.setOption('requireSpaceBeforeHeadingText', true);

converter.setOption('ghCodeBlocks', true);
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

function insertTextAtCursor() {
	var editor = myCodeMirror;
	var text = "hello world !";
    var doc = editor.getDoc();
    var cursor = doc.getCursor();
    doc.replaceRange(text, cursor);
}




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
