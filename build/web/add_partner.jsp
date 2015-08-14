<%-- 
    Document   : add_partner2
    Created on : Sep 13, 2019, 8:14:16 AM
    Author     : Geofrey Nyabuto
--%>
<%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
    if (session.getAttribute("userid")==null || !session.getAttribute("level").toString().equals("1")) {
        response.sendRedirect("index.jsp");
    } 
%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link href="menu/style.css" media="screen" rel="stylesheet" type="text/css" />
<link href="menu/iconic.css" media="screen" rel="stylesheet" type="text/css" />
         <link rel="shortcut icon" href="images/header.JPG"/>
     <script type="text/javascript" src="js/jquery-1.9.1.js"></script>

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>
<title>Add Partners.</title>
 <!--ANIMATTED ALERTS FROM THE SYSTEM-->   
   	<script src="Alerts/alertify.js"></script>
	<script src="Alerts/alertify.min.js"></script>   
       <link rel="stylesheet" href="Alerts/alertify.core.css">
       <link rel="stylesheet" href="Alerts/alertify.default.css">
<script type="text/javascript">
  function nullchecker(){
  
  var dist1,dist2,dist3,dist4,dist5,dist6,dist7,dist8,dist9,dist10,dist11,dist12,dist13,dist14,dist15;    
  dist1=document.getElementById('dist1').value;    
  dist2=document.getElementById("dist2").value;
  dist3=document.getElementById("dist3").value;
  dist4=document.getElementById("dist4").value;
  dist5=document.getElementById("dist5").value;
  dist6=document.getElementById("dist6").value;
  dist7=document.getElementById("dist7").value;
  dist8=document.getElementById("dist8").value;
  dist9=document.getElementById("dist9").value;
  dist10=document.getElementById("dist10").value;
  dist11=document.getElementById("dist11").value;
  dist12=document.getElementById("dist12").value;
  dist13=document.getElementById("dist13").value;
  dist14=document.getElementById("dist14").value;
  dist15=document.getElementById("dist15").value;
//  alert(dist1);
  if(dist1=="" && dist2=="" && dist3=="" && dist4=="" && dist5=="" &&
dist6=="" && dist7=="" && dist8=="" && dist9=="" && dist10=="" &&
dist11=="" && dist12=="" && dist13=="" && dist14=="" && dist15==""){  
      alertify.alert("Register Atleast one Partner.");
      return false;
  }
   else{
       
       
       return true;
   }   
      
      
  }  
</script> 
</head>
<body>

<div id="container" >
            <%@include file="/menu/super_admin.jsp"%>
    
            <h3 style="text-align: center; background-color: #d6b4eb;">ADDING PARTNERS</h3>
<div id="content" style="height:520px;">
    <%if (session.getAttribute("fullname")!=null){ %>
    <div style="margin-left: 20px; margin-top: 10px; font-size: 17px;">
    Hi, <u><%=session.getAttribute("fullname").toString()%>  </u>       
</div> <%}%>
<div id="midcontent" style="margin-left:230px ; width: 750px; height: 400px;">
    
    <%if (session.getAttribute("dist_exist") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("dist_exist")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 3800});
                    
                </script> <%
                session.removeAttribute("dist_exist");
                            }

                        %>
                        
                            <%if (session.getAttribute("dist_exist2") != null) { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("dist_exist2")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 3800});
                    
                </script> <%
                session.removeAttribute("dist_exist2");
                            }

                        %>
                        
<h5>Add one or more partners.</h5>

<form action="add_partner" name="form" onsubmit="return nullchecker();" method="post" >
    <br>
<!--    <h4 style="color: #330033; height: 25px;">County Name:&nbsp;&nbsp;&nbsp;&nbsp;||&nbsp;&nbsp;&nbsp;&nbsp;District Name:</h4>
    -->
       <table cellpadding="2px" cellspacing="3px" border="1px" class="table_style">
           <tr><td><input type="text" name="dist1"  value="" id="dist1" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/></td><td>
            <input type="text" name="dist2" id="dist2" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td><td>
    <input type="text" name="dist3"  id="dist3" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td></tr>
    <tr></tr>
            <tr><td><input type="text" name="dist4" id="dist4" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/></td><td>
            <input type="text" name="dist5"  id="dist5" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td><td>
    <input type="text" name="dist6" value="" id="dist6" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td></tr>
            <tr></tr>    
           <tr><td><input type="text" name="dist7" id="dist7" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/></td><td>
            <input type="text" name="dist8" id="dist8" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td><td>
    <input type="text" name="dist9" id="dist9" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td></tr>
                      <tr><td><input type="text" name="dist10" id="dist10" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/></td><td>
            <input type="text" name="dist11" value="" id="dist11" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td><td>
    <input type="text" name="dist12" value="" id="dist12" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td></tr>
     <tr><td><input type="text" name="dist13" id="dist13" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/></td><td>
            <input type="text" name="dist14" id="dist14" value="" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td><td>
    <input type="text" name="dist15" value="" id="dist15" placeholder="Enter Partner Name" class="textbox" style="background: #6699ff"/>    
    </td></tr>
                      <tr><td colspan="3"><input type="submit" name="sub" value="Save Partners" class="textbox1" style="background: #cc99ff; color: #0000ff"></td></tr>
</table>
       <br><br>
</form>
</div>
</div>


<div id="footer">
 <%
Calendar cal = Calendar.getInstance();
int year= cal.get(Calendar.YEAR);              

%>
               <p align="center">PWP System &copy Aphia Plus | USAID <%=year%></p>
</div>
</div>    

</body>
</html>
