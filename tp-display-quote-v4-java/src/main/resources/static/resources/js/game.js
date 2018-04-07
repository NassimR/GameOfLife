var parentDiv = document.getElementById('gamePanel');

var maxHeight = 600;
var maxWidth = 1200;

var currentGeneration = 1;
var currentModel = 1;
var playState = 0;

var loadModel =function(){
    var gameId = document.getElementById("gameIdInput").value;

    if(parseInt(gameId))
    {
        $.ajax({
            type:"GET",
            url: '/api/games/'+parseInt(gameId)+'/generation/1',
            data: {
                text: $("textarea[name=Status]").val(),
            },
            dataType : 'json',
            success:function(responsedata){
                // process on data
                //alert("got response");
                createGrid(responsedata);
                currentGeneration=1;
                document.getElementById("currGen").innerHTML=1;
                currentModel=parseInt(gameId);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("Status: " + textStatus); alert("Error: " + errorThrown);
            }
        });
    }
    else {
        alert("Le numéro du jeu n'est pas correct");
    }
};

function evolution(way){
    if(way === 1 ){
        currentGeneration+=way;
        document.getElementById("currGen").innerHTML=currentGeneration;
    }
    else{
        if(currentGeneration>1){
            currentGeneration--;
            document.getElementById("currGen").innerHTML=currentGeneration;
        }
    }

    $.ajax({
        type:"GET",
        url: '/api/games/'+currentModel+'/generation/'+currentGeneration,
        data: {
            text: $("textarea[name=Status]").val(),
        },
        dataType : 'json',
        success:function(responsedata){
            // process on data
            //alert("got response");
            createGrid(responsedata);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("Status: " + textStatus); alert("Error: " + errorThrown);
        }
    });
}

var play = function() {
    playState=1;
    document.getElementById("playGen").style.display="none";
    document.getElementById("pauseGen").style.display="inline-block";

    var i = 0;
    var intr = setInterval(function() {
       evolution(1);
       if (playState==0) clearInterval(intr);
    }, 250)
}

var pause = function() {
    playState=0;
    document.getElementById("playGen").style.display="inline-block";
    document.getElementById("pauseGen").style.display="none";
}

function createGrid(jsonLoaded){
    // On teste si les données sont coherentes
    if(jsonLoaded.world.length === jsonLoaded.lignes && jsonLoaded.world[0].length === jsonLoaded.collonnes){

        while (parentDiv.firstChild) {
          parentDiv.removeChild(parentDiv.firstChild);
        }

        var cHeight, cWidth;

        var heightRatio = maxHeight/jsonLoaded.lignes;
        var widthRatio = maxWidth/jsonLoaded.collonnes;

        if(heightRatio<widthRatio){
            cHeight=maxHeight;
            cWidth=jsonLoaded.collonnes*heightRatio;
            widthRatio = cWidth/jsonLoaded.collonnes;
        }
        else{
            cHeight=jsonLoaded.lignes*widthRatio;
            cWidth=maxWidth;
            heightRatio = cHeight/jsonLoaded.lignes;
        }

        var my_canvas = document.createElement("canvas");
        my_canvas.height=cHeight;
        my_canvas.width=cWidth;
        my_canvas.style.background = '#fcc';
        my_canvas.style.borderStyle = "solid";

        parentDiv.appendChild(my_canvas);

        var context = my_canvas.getContext("2d");

        context.fillStyle = "#aa4d4d";

        for(i = 0; i<jsonLoaded.lignes; i++){
            for(j = 0; j<jsonLoaded.collonnes; j++){
                //console.log(i," et ",j);
                //console.log(j*heightRatio,i*widthRatio,widthRatio,heightRatio);

                if(jsonLoaded.world[i][j]){
                    context.fillRect(j*heightRatio,i*widthRatio,widthRatio,heightRatio);
                }
            }
        }

        for(i = 0; i<jsonLoaded.lignes + 1; i++){
            context.beginPath();
            context.moveTo(0,i*heightRatio);
            context.lineTo(cWidth,i*heightRatio);
            context.stroke();
        }

        for(i = 0; i<jsonLoaded.collonnes + 1; i++){
            context.beginPath();
            context.moveTo(i*widthRatio,0);
            context.lineTo(i*widthRatio,cHeight);
            context.stroke();
        }
    }
    else{
        var error_text = document.createElement("h3");
        error_text.style.color="red";
        error_text.innerHTML="Il y a une erreur dans le fichier charge, il n'existe pas ou n'est pas conforme.";
        parentDiv.appendChild(error_text);
    }
}

loadModel();

var downloadBut = document.getElementById("downloadInput");
var evolveBut = document.getElementById("nextGen");
var deevolveBut = document.getElementById("prevGen");
var playBut = document.getElementById("playGen");
var pauseBut = document.getElementById("pauseGen");

downloadBut.addEventListener('click', loadModel, false);
evolveBut.addEventListener('click', function() {evolution(1);}, false);
deevolveBut.addEventListener('click', function() {evolution(-1);}, false);
playBut.addEventListener('click', play, false);
pauseBut.addEventListener('click', pause, false);

debugger;