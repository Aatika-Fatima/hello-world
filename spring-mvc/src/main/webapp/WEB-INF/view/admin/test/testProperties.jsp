<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
    <head>
        <title>Bootstrap Case</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
         
    </head>
    <body>

        <div class="container">
            <h2>Dynamic Pills</h2>
            <p>To make the tabs toggleable, add the data-toggle="pill" attribute to each link. Then add a .tab-pane class with a unique ID for every tab and wrap them inside a div element with class .tab-content.</p>
            <ul class="nav nav-pills">
                <li class="active"><a data-toggle="pill" href="#information">Information</a></li>
                <li><a data-toggle="pill" href="#menu1">Settings</a></li>
                <li><a data-toggle="pill" href="#menu2">Publish</a></li>
            </ul>

            <div class="tab-content">
                <div id="information" class="tab-pane fade in active">
                    <div class="container">
                        <br>
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="email">Test Title:</label>
                                <div class="col-sm-10">
                                    <select class="form-control" id="sel1">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pwd">Author:</label>
                                <div class="col-sm-10">          
                                    <select class="form-control" id="sel1">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-2" for="pwd">Description:</label>
                                <div class="col-sm-10">          
                                    <textarea class="form-control" rows="3" id="comment"></textarea>      </div>
                            </div>

                            <div class="form-group">        
                                <div class="col-sm-offset-5 col-sm-10">
                                    <button type="submit" class="btn btn-default">Submit</button>
                                    <button type="reset" class="btn btn-default">Reset</button>
                                </div>
                            </div>
                        </form>

                    </div>

                </div>
                <div id="menu1" class="tab-pane fade">
                    <h3>Menu 1</h3>
                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                </div>
                <div id="menu2" class="tab-pane fade">
                    <h3>Menu 2</h3>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
                </div>
                <div id="menu3" class="tab-pane fade">
                    <h3>Menu 3</h3>
                    <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                </div>
            </div>
        </div>

    </body>
</html>
