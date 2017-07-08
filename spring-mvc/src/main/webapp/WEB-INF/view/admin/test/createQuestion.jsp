<%@include file="/WEB-INF/view/include/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="/WEB-INF/view/include/scripts.jsp"%>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
</head>
<body>
<div id="demo" class="collapse">
    <h2>Question</h2>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Category:</label>
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
                    <label class="control-label col-sm-2" for="pwd">Category:</label>
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
                    <label class="control-label col-sm-2" for="pwd">Question:</label>
                    <div class="col-sm-10">          
                        <textarea class="form-control" rows="3" id="comment"></textarea>      </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd"><div class="radio">
                            <label><input type="radio" name="optradio">A</label>
                        </div></label>
                    <div class="col-sm-10">          
                        <textarea class="form-control" rows="2" id="comment"></textarea>      </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd"><div class="radio">
                            <label><input type="radio" name="optradio">B</label>
                        </div></label>
                    <div class="col-sm-10">          
                        <textarea class="form-control" rows="2" id="comment"></textarea>      </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd"><div class="radio">
                            <label><input type="radio" name="optradio">C</label>
                        </div></label>
                    <div class="col-sm-10">          
                        <textarea class="form-control" rows="2" id="comment"></textarea>      </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd"><div class="radio">
                            <label><input type="radio" name="optradio">D</label>
                        </div></label>
                    <div class="col-sm-10">          
                        <textarea class="form-control" rows="2" id="comment"></textarea>      </div>
                </div>

                <div class="form-group">        
                    <div class="col-sm-offset-5 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                        <button type="reset" class="btn btn-default">Reset</button>
                    </div>
                </div>

            </form>
  </div>
</body>
</html>