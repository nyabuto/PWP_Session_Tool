<%-- 
    Document   : user
    Created on : Jan 19, 2015, 11:42:43 AM
    Author     : Geofrey Nyabuto
--%>

<!DOCTYPE html>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='css/styles.css' />
        <link rel='stylesheet' type='text/css' href='css/buttons.css' />

</head>
<body>
<div id='cssmenu'>
<ul>
 <li class='has-sub'><a href='#'><span class="btn_header">Add Entries</span></a>
      <ul>
<!--         <li class='has-sub'><a href='add_clerk.jsp'><span>Add System User</span></a></li>-->
          <li class='has-sub'><a href='ClientRegistrationForm.jsp'><span>Registration Form</span></a></li>
           <li class='has-sub'><a href='ChooseAssessment.jsp'><span>Assessment Form</span></a></li>
      </ul>
   </li>
        <li class='has-sub'><a href='add_a_group.jsp'><span class="btn_header">PWP Form Entry</span></a>
      <ul>
         <li class='has-sub'><a href='add_a_group.jsp'><span>PWP Form Entry</span></a>
         </li></ul>
   </li>
      <li class='has-sub' style="z-index: 999;"><a href='#'><span class="btn_header">Edit Entries</span></a>
      <ul>
 <li class='has-sub'><a href='EditGroup.jsp'><span>Edit Group</span></a></li>
         <li class='has-sub'><a href='EditProviders.jsp'><span>Edit Service Provider</span></a>
         <li class='has-sub'><a href='ChooseClient.jsp'><span>Edit Registration form </span></a></li>
         <li class='has-sub'><a href='chooseEditAssessment.jsp'><span>Edit assessment form </span></a></li>
         </li>
      </ul>
   </li>
    <li class='has-sub' style="z-index: 999;"><a href='#'><span class="btn_header">Management</span></a>
 <ul>
            <li><a href='edit_ur_details.jsp'>Edit Profile</a></li>
            <!--<li><a href='copyClientDetails.jsp'>Move Clients</a></li>-->
            <li><a href='timestamp.jsp'>Change last backup date</a></li>
 </ul>
   </li>
      <li class='has-sub' style="z-index: 999;"><a href='#'><span class="btn_header">Data</span></a>
 <ul>
        <li class='has-sub'><a href='#'><span>DQA</span></a>
 <ul>
             <li class='has-sub'><a href='DuplicateEntries.jsp'><span>Duplicates</span></a></li>
             <li class='has-sub'><a href='SyncChecker.jsp'><span>Late Entries</span></a></li>


      </ul>
   </li>
     <li><a href='set_email.jsp'>Set/Edit M&E Officer Email</a></li>
<li class='has-sub'><a href='ExportData.jsp'><span>Back up data</span></a> </li>
      </ul>
   </li>
    
    
   
   <li class='has-sub' style="z-index: 999;"><a href='#'><span class="btn_header">Reports</span></a>
      <ul>
       <li class='has-sub'><a href='#'><span>1. Custom reports</span></a>
         <ul>
          <li class='has-sub'><a href='enrollments.jsp'><span>1.Enrollments Report</span></a></li>
          <li class='has-sub'><a href='CustomRawData.jsp'><span>2. Messages Given</span></a></li>
         <!--<li class='has-sub'><a href='servicesProvided.jsp'><span>3. Services Provided</span></a></li>-->
         </ul>
         </li> 
         <li class='has-sub'><a href='rawData.jsp'><span>2. Raw Data</span></a></li>
         <li class='has-sub'><a href='kePMS.jsp'><span>3. KePMS Report</span></a></li>
         <li class='has-sub'><a href='kePMSNotAchieved'><span>4. Clients not reached</span></a></li>
         
      </ul>
   </li> 
    <li><a href='help/PWPPresentationSlides.pdf' target="_blank" title="if it opens up a new tab with errors, try refreshing the page i. e press f5 button on you computer keyboard"><span  class="btn_header">Help</span></a></li> 
   <li class='last'><a href='logout.jsp'><span class="btn_header">Log Out</span></a></li>
</ul>
</div>
</body>
</html>
