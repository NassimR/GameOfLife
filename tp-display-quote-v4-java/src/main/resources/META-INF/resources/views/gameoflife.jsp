<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Game of Life</title>
        <script type="text/javascript" src="/resources/js/jquery-2.2.0.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>

    <body>
        <div class="container">
             <div class="row">
                <div class="col-md-3"><h2>Game of Life</h2></div>
                <div class="col-md-1">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default">Play the life</button>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="btn-group" role="group">
                        <button id="uploadInput" type="file" class="btn btn-default">Upload a model</button>
                        <button id="downloadInput" class="btn btn-default" type="button">Download:</button>
                        <input id="gameIdInput" type="text" style="width:100px" class="form-control" placeholder="gameId" value="1">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="btn-group" role="group">
                      <button id="playGen" type="button" class="btn btn-default">Play the life</button>
                      <button id="pauseGen" type="button" class="btn btn-default" style="display:none;">Pause the life</button>
                      <button id="nextGen" type="button" class="btn btn-default">Evolve</button>
                      <button id="currGen" type="button" disabled class="btn btn-default">1</button>
                      <button id="prevGen" type="button" class="btn btn-default">De-evolve</button>
                    </div>
                </div>
            </div>

            <center>
                <div id='gamePanel'>
                </div>
            </center>
        </div>
        <script type="text/javascript" src="/resources/js/game.js"></script>

    </body>
</html>