<%-- 
    Document   : enrollments
    Created on : Nov 7, 2014, 11:10:15 AM
    Author     : Geofrey Nyabuto
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Completion Summary.</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<link rel="shortcut icon" href="images/header.JPG"/>
<link href="css/style.css" media="screen" rel="stylesheet" type="text/css" />

<script src="prefix-free.js"></script>
   
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>

 <!-- ANIMATE HELP    -->
   <link rel="stylesheet" href="themes/base/jquery.ui.all.css">
<!--	<script src="js/jquery-1.9.1.js"></script>-->
	<script src="ui/jquery.ui.core.js"></script>
	<script src="ui/jquery.ui.widget.js"></script>
	<script src="ui/jquery.ui.mouse.js"></script>
	<script src="ui/jquery.ui.draggable.js"></script>
	<script src="ui/jquery.ui.position.js"></script>
	<script src="ui/jquery.ui.resizable.js"></script>
	<script src="ui/jquery.ui.button.js"></script>
	<script src="ui/jquery.ui.dialog.js"></script>
	<script src="ui/jquery.ui.effect.js"></script>
	<script src="ui/jquery.ui.effect-blind.js"></script>
	<script src="ui/jquery.ui.effect-explode.js"></script>
	<link rel="stylesheet" href="ui-essentials/demos.css">
        <!--calender-->
<script type ="text/javascript" src="js/datepicker/min.js"></script>
<script type ="text/javascript" src="js/datepicker/jquery.jdpicker.js"></script>
<link rel="stylesheet" href="js/datepicker/jdpicker.css" type="text/css" media="screen" /> 
 <script>
	$(function() {
                 var dateObject,day,month,year,current_date;
    dateObject =new Date();
    day=dateObject.getDate();
    month=dateObject.getMonth()+1;
    year=dateObject.getFullYear();
    //fully year separated by backward slash
   current_date=day+"/"+month+"/"+year; 
   
   
       $('#datepicker').jdPicker({
     date_format:"dd/mm/YYYY",
     show_week:1,
     week_label:"we",
     start_of_week:3,
     date_min:"01/01/2010",
     date_max:current_date,
     selectable_days:[1, 2, 3, 4, 5]
//     non_selectable:["May 24 2000"],
//     rec_non_selectable: ["Jan 01", "May 26"]
}); 

 $('#datepicker2').jdPicker({
     date_format:"dd/mm/YYYY",
     show_week:1,
     week_label:"we",
     start_of_week:3,
     date_min:"01/01/2010",
     date_max:current_date,
     selectable_days:[1, 2, 3, 4, 5]
//     non_selectable:["May 24 2000"],
//     rec_non_selectable: ["Jan 01", "May 26"]
}); 
$('#test2').jdPicker({
     date_format:"dd/mm/YYYY",
     select_week:1,
     show_week:1,
     date_min:"01/01/2010",
     date_max:current_date
}); 
	});
	</script> 
    </head>
    <body>
        
    <div id="container" style="height: auto;">
        
   <%if(session.getAttribute("level")!=null){if (session.getAttribute("level").toString().equals("2")){ %>
<%@include file="/menu/user.jsp" %>
<%} else if (session.getAttribute("level").toString().equals("1")){%>
<%@include file="/menu/super_admin.jsp" %>
<%} else if (session.getAttribute("level").toString().equals("3")){%>
<%@include file="/menu/Officer.jsp" %>
<%} else if (session.getAttribute("level").toString().equals("5")){%>
<%@include file="/menu/guest_menu.jsp" %>
<%}else{}}%>
<div id="header" align="center">
<br/>
</div>
<div id="content" style="height:auto">
    <%if (session.getAttribute("fullname")!=null){ %>
    <div style="margin-left: 20px; margin-top: 10px; font-size: 17px;">
    Hi, <u><%=session.getAttribute("fullname").toString()%>  </u>       
</div> <%}%>
<div style="margin-left: 300px;width: 550px; margin-top: -10px; color: #000; background: #d6b4eb; font-size: 24px; text-align: center;">Sessions completion report.</div>


<div id="midcontent" style="margin-left:230px ; height: auto">
<div >    <h4 style=" font-size: 23px;">Specify details appropriately to generate report.<img src="images/help.png" id="opener" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 40px; height: 40px;"></h4></div> 
<div id="dialog" title="Add Clients Help." style=" font-size: 17px;">
<p></p>
</div>
<p style=" font-size: 20px;"><font color="red" >*</font> indicates must select fields</p>
<form action="completedSessions" method="post">
<table cellpadding="2px" cellspacing="3px" border="0px">
 
<tr> <td class="align_button_right" style=" font-size: 18px;">Choose Start Date <font color="red">*</font></td>
    <td><input type="text" name="start_date" maxlength="10" id="datepicker" placeholder="Select Start Date" value="" class="textbox" required>   
    </td>
</tr>

<tr> <td class="align_button_right" style=" font-size: 18px;">Choose End Date<font color="red">*</font></td>
    <td><input type="text" name="end_date" maxlength="10" placeholder="Select End Date" id="datepicker2" value="" class="textbox"  required>   
    </td>
</tr>
</td><td></td></tr>
<tr><td></td><td><input type="submit" value="Generate" class="submit"/></td></tr>
</table>
</form>
</div>
</div>

<div id="footer">
<%
Calendar cal = Calendar.getInstance();
int year= cal.get(Calendar.YEAR);              

%>
               <p align="center" style=" font-size: 18px;"> &copyPWP System Aphia Plus | USAID <%=year%></p>
            </div>
</div>    

    </body>
</html>
