var el = document.getElementById("generator");

var result = "Generation 1:\n";

function aleatoire(N) { 
	return (Math.floor((N)*Math.random()+1)); 
}

var maxSize = 100;

var width = aleatoire(maxSize);
var height = aleatoire(maxSize);

var p = 0.1;

result+= width + " " + height + "\n";

for(i=0; i<width; i++){
	for(j=0; j<height; j++){
		if(Math.random() > p){
			result+=".";
		}
		else{
			result+="*";
		}
	}
	result+="\n";
}

function nl2br (str, is_xhtml) {
    if (typeof str === 'undefined' || str === null) {
        return '';
    }
    var breakTag = (is_xhtml || typeof is_xhtml === 'undefined') ? '<br />' : '<br>';
    return (str + '').replace(/([^>\r\n]?)(\r\n|\n\r|\r|\n)/g, '$1' + breakTag + '$2');
}

el.innerHTML=nl2br(result);