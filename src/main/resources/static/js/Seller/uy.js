/*GLOABAL VARS */

let activeProgrammeCard=null; // <HTML Script Element>
let projectActiveFilter=null; // Array 
document.getElementById('pills-project-tab').click();


var dtTable=null;

function renderProjectList(selectedElement){
	let htmlToRender=``;
	let projectElement= document.getElementById('pills-projectList');
	
	 if(projectList!=null && projectList!=undefined  && projectList!=0){
		 projectList.forEach((ele)=>{
			 htmlToRender+=`
				 <div class="animated  fadeInDown bg-white cursor-pointer  m-4 float-left my-card" style="width:300px;" data-projectId="${ele.id}" onclick="workSpaceManager.loadProject(this);">      
				   <div style="display: flex;">
					<span class="p-my icon-background">
						<i style="font-size: 2.5rem !important;" class="${ ele.projectMethodology == 0 ?  'icon-agile' : 'icon-waterfall' }"></i>	
					</span>           
					
					<div class="p-0 pl-2 pt-1" style="width: 74%;>
						<div class="pl-2 pr-3  title-projectName" style="width:100%;">
							<h5 title="${ele.name}" class="text-truncate pt-2" style="width:100%;">
								${ele.name}
							</h5> 
							
							<small class="title-projectName font-weight-bold" style="opacity: 0.6;" title="${ (ele.programme!=null && ele.programme !=undefined) ? ele.programme.name: null }">
							     ${ ele.programme!=null && ele.programme !=undefined ? ele.programme.name : '' }
							</small>
					
				 	   </div>	
				   </div>
				 </div>
				 </div>
				`; 
		 });
		 
	 }else{
		 svgImage=dynamicSvgList;
		 svgImage.options.height='300px';
		 svgImage.options.width='600px';
		 
		 htmlToRender=`
			 <div>    
			 	<center>
			 	${svgImage.imageList('undrawEmptyBox')}
			 	</center>
				<h1 style="font-size:2rem !important;" class="text-center  p-0 pt-5 pb-3 m-4"> You Have No Active Project</h1>
				<h6 class="text-center  p-2">
				${Session.user.role.id  == 2 ?  
					'<b>Go to Setting</b>: Create Project or Activate any' 
					: 'Ask <b>Admin</b> to assign you project'  }</h6>    
			</div>
		 `;
	 }
	 
	 projectElement.innerHTML=htmlToRender;
 }
 function renderProgrammeList(selectedElement){
	 let activeProgrammeId = null;
	 if(activeProgrammeCard!=null && activeProgrammeCard!=undefined){
		 activeProgrammeId =activeProgrammeCard.getAttribute('data-programmeId');
	 }
	 
	 let htmlToRender=``;
		let programmeElement= document.getElementById('programme-list-scroll');
		
		 if(programmeList!=null && programmeList!=undefined){
			
			 programmeList.forEach((ele)=>{
				 htmlToRender+=`
					 
					 	 <div style="width:100%;height: 69px;" class="p-2 animated  fadeInDown" data-programmeId="${ele.id}" onClick="renderProjectOfProgramme(this);">
									<div class="row card-tm card-tm-hover cursor-pointer" >
										<div class="col-md-3 col-sm-3  p-3 
												${ (( activeProgrammeId!=null && activeProgrammeId!=undefined ) && (activeProgrammeId == ele.id)) ? 'card-active-programme': '' }
										" style="color: #fff;background: var(--primary-color);">
											<i style="font-size: 1.5rem !important;" class="fas fa-sitemap  p-1 pl-0" ></i>
										</div>
										<div class="col-md-9 col-sm-9 p-2 pl-2 ">
											${ele.name}
										</div>
					 					
										
									</div>
								</div>
				 
					
					`; 
			 });
			 
		 }else{
			 svgImage=dynamicSvgList;
			 svgImage.options.height='300px';
			 svgImage.options.width='300px';
			 
			 htmlToRender=`
				 <div>    
				 	<center>
				 	${svgImage.imageList('undrawEmptyBox')}
				 	
				 	</center>
					<h1 style="font-size:2rem !important;" class="text-center  p-0 pt-5 pb-3 m-4"> You Have No Active Project</h1>
					<h6 class="text-center  p-2">
					${Session.user.role.id  == 2 ?  
						'<b>Go to Setting</b>: Create Programme or Activate any' 
						: 'Ask <b>Admin</b> to assign you Programme'  }</h6>    
				</div>
			 `;
		 }
		 
		 programmeElement.innerHTML=htmlToRender;
	 
 }
 
 function renderProjectOfProgramme(selectedElement){
	 let selectedElementId = selectedElement.getAttribute('data-programmeId');
	 let projectListOfProgrammeElement = document.getElementById("programmeProjectListBody");
	 let activeProgramme=[];
	 let htmlToRender=``;
	 projectActiveFilter=[];
	 
	 
	 
	 
//	  document.getElementsByClassName('card-active-programme').forEach((ele)=>{
//				ele.classList.remove('card-active-programme'); 
//			 });
	
	 
	if(activeProgrammeCard!=null && activeProgrammeCard!=undefined){
		
		activeProgrammeCard.children[0].children[0].classList.remove('card-active-programme');
		
		document.querySelectorAll(`[data-programmeId="${activeProgrammeCard.getAttribute('data-programmeId')}"]`)[0].children[0].children[0].classList.remove('card-active-programme');
		//document.querySelectorAll('[programme-id='+activeProgrammeCard.getAttribute('data-programmeId')+']');
	}
	 
	
	 selectedElement.children[0].children[0].classList.add('card-active-programme');
	 activeProgrammeCard=selectedElement;
	 projectList.forEach((ele,count)=>{
		 
	    	if( ele.programme!=null && ele.programme!=undefined && ele.programme.id==selectedElementId){
		         
	    		 activeProgramme.push(ele);
		         projectActiveFilter.push(ele.id);
		         
		      }
	    
		 
	 });
	 
	 
	 
	 
	 if(activeProgramme!=null && activeProgramme!=undefined && activeProgramme!=0){
		 
		 document.getElementsByClassName('workspace-of-programme')[0].innerHTML="";
		 
		 document.getElementsByClassName('progarmme-list-project-button')[0].style.display="block";		 
		 
		 renderDashBoardWorkSpace();
		 
		 activeProgramme.forEach((ele,count)=>{
					
					 htmlToRender+=` 
						 <tr data-projectId="${ele.id}">
						 	<td class="text-center"><input type="checkbox" name="programmeProjectSelectAll_checkbox" onclick="checkSelection(this)" data-dataObject="${ele.id}" data-name="${ele.name}" checked /> </td>
						 	<td class="text-left">${ele.name}</td>
						 	<td class="text-center"><i style="font-size: 1rem !important;" class="${ ele.projectMethodology == 0 ?  'icon-agile' : 'icon-waterfall' }  p-1 pl-0" ></i></td>
						 </tr>
			
				 	`;
	
			 });
		 
		 
		 
		 
	 }else{
		 document.getElementsByClassName('opptionBar')[0].style.display="none";
		 projectFilterSideNavClose();
		 projectListOfProgrammeElement=document.getElementsByClassName('workspace-of-programme')[0];
		 document.getElementsByClassName('progarmme-list-project-button')[0].style.display="none";
		 svgImage=dynamicSvgList;
		 svgImage.options.height='400px';
		 svgImage.options.width='30%';
		 htmlToRender+=`
			 <div class="text-center justify-content-center align-self-center align-items-center">
			 	
			 	${svgImage.imageList('undrawEmptyBox')}
			 	<h4 style="font-size:1.5rem !important;font-wa">No Project Found</h4>
			 </div>`;
	 }
	 
	 
	 
	 projectListOfProgrammeElement.innerHTML=htmlToRender;
 }
 
 
 function projectFilterSideNavOpen(){
	 
	 document.getElementById('programmeProjectList_search').removeAttribute('disabled');
	 	
	 if(null == dtTable || undefined == dtTable){
		 
		 dtTable=$('#programmeProjectList_Table').DataTable({
		 		columnDefs: [
					{   targets: 0,
						className: "dt-body-center"
					},
					{
						targets: [0,2], /* column index */

				        orderable: false, /* true or false */
					}
					],
				language: {
			        paginate: {
			          next:'<i class="fas fa-caret-right" ></i>',    
			          previous: '<i class="fas fa-caret-left" ></i>'
			        }
			      },
			    pageLength: 20,
				lengthChange: false,
				searching: true,
				 scrollY:'calc (100% - 7vh)',
			} );
		 	
			setTimeout(()=>{
							
				$("#programmeProjectList_search").keyup(function (){
					searchInTable(dtTable,$(this).val(),this);
				});
				
			},0);
			
			document.getElementById('programmeProjectList_Table_filter').remove();
		 
	 }
	 
	 	
	 	let projectMain= document.getElementsByClassName('project-List-Side-Nav')[0];
	 	projectMain.style.right="0";
	 	
	 	
	 	
	 	
 }
function projectFilterSideNavClose(){
	
	document.getElementById('programmeProjectList_search').setAttribute('disabled','disabled');
	
	let projectMain= document.getElementsByClassName('project-List-Side-Nav')[0];
 	projectMain.style.right="-26vw";
 	
} 
 
function select_all(element){
	if(null != dtTable && undefined != dtTable){
		if(element.checked){
			dtTable.$("input:checkbox[name=programmeProjectSelectAll_checkbox]").prop("checked",true);
		}else{
			dtTable.$("input:checkbox[name=programmeProjectSelectAll_checkbox]").prop("checked",false);
		}
	}
}


function renderDashBoardWorkSpace(){
	
	document.getElementsByClassName('opptionBar')[0].style.display="Block";
	
	let workspace=document.getElementsByClassName('workspace-of-programme')[0];
	let htmlToRender=``;
	/*Spark Lines DIVS*/


	/*Graphs DIVS*/
	 htmlToRender+=`
	 	<div class="row m-0 p-0">
	        <div class="col-md-4 p-2"> 
	            <div style="height:100%;width:100%" class="card-tm p-3 animated fadeInRight" >
		 			<div class="row pt-1">
		 				<div class="col-md-6 col-sm-6"> 
		 					<p class="m-0" style="font-size: 1.1rem !important;font-weight: 100;opacity: 0.7;color: var(--primary-color);">Requirement <span id="req-total" class="badge badge-primary" data-toggle="tooltip" data-placement="right"  data-html="true" title="Total Requirement " >...</span></p>
		 				</div>
		 				
		 				<div class="col-md-6 col-sm-6"> 
		 							<!--SELECT with pure css-->
							    	<div class="select">
										<select class="select-text p-0" id="reqirement_type" onchange="updateReqFilterData(this,true)">
											<option value="MOSCOW" selected> MOSCOW </option>
											<option value="CATEGORY"> Category </option>
											<option value="STATUS"> Status </option>
										</select>
										<span class="select-highlight"></span>
										<span class="select-bar"></span>
										
									</div>
							  <!--SELECT with pure css-->
		 				</div>
		 			</div>
	            	<div id="req-all-filter" style="height:100%;width:100%;">
		                						
		            </div>
		               
		         </div>
	        </div>
	        
	        
	        <div class="col-md-4 p-2"> 
	            <div style="height:100%;width:100%" class="card-tm p-3 animated fadeInRight" >
		 			<div class="row pt-1">
		 				<div class="col-md-6 col-sm-6"> 
		 					<p class="m-0" style="font-size: 1.1rem !important;font-weight: 100;opacity: 0.7;color: var(--primary-color);">Test Case <span id="testCase-total" class="badge badge-primary" data-toggle="tooltip" data-placement="right"  data-html="true" title="Total Test Case " >...</span></p>
		 				</div>
		 				
		 				<div class="col-md-6 col-sm-6"> 
		 							<!--SELECT with pure css-->
							    	<div class="select">
										<select class="select-text p-0" id="testCase_type" onChange="updateTestCaseFilterData(this,true)">
											<option selected value="STATUS"> Status </option>
											<option value="TEST_TYPE"> Test Case Type </option>
											<option value="TEST_PHASE"> Test Phase </option>
											<option value="TEST_TYPE"> Test Type </option>
											<option value="TEST_CASE_EXECUTION_STATUS"> Test Case Execution Status </option>
											<option value="PRIORITY"> Priority</option>
											
											
										</select>
										<span class="select-highlight"></span>
										<span class="select-bar"></span>
										
									</div>
							  <!--SELECT with pure css-->
		 				</div>
		 			</div>
		 			
		 			
		 			
	            	<div id="testCase-all-filter" style="height:100%;width:100%;">
		                						
		            </div>
		               
		         </div>
	
	        </div>
	        
	        <div class="col-md-4 p-2"> 
	            <div style="height:100%;width:100%" class="card-tm p-3 animated fadeInRight" >
	            	<div class="row pt-1">
		 				<div class="col-md-6 col-sm-6"> 
		 					<p class="m-0" style="font-size: 1.1rem !important;font-weight: 100;opacity: 0.7;color: var(--primary-color);">Incident <span id="incident-total" class="badge badge-primary" data-toggle="tooltip" data-placement="right"  data-html="true" title="Total Incident " >...</span> </p>
		 				</div>
		 				
		 				<div class="col-md-6 col-sm-6"> 
		 							<!--SELECT with pure css-->
							    	<div class="select">
										<select class="select-text p-0" id="incident_type"  onChange="updateIncidentFilterData(this,true)">
											<option value="priority" selected> Priority </option>
											<option value="incident_Test_Area" > Incident Test Area </option>
											<option value="severity" > Severity </option>
											<option value="state" > State </option>
											<option value="testing_Phase" > Testing Phase</option>
											<option value="status" > Status</option>
											
											
										</select>
										<span class="select-highlight"></span>
										<span class="select-bar"></span>
										
									</div>
							  <!--SELECT with pure css-->
		 				</div>
		 			</div>
	            	
	            	<div id="incident-all-filter" style="height:100%;width:100%;">
		            
		            </div>
		         </div>
	        </div>
    </div>
	 
	<div class="row m-0 p-0">
        <div class="col-md-12 p-2"> 
            <div style="height:100%;width:100%" class="card-tm p-3 d-flex animated fadeInRight" >

            	   
            	<div class="col-md-12 " id="projectProgressReportElement" style="height:100%;width:100%;">
	                
	            </div>
	               
	         </div>
            
        
            
            
        </div>
    </div>
    
    <div class="row m-0 p-0 " id="project-graph-section" style="display:none">
       
       <!-- col 1 -->
       
        <div class="col-md-4 p-2"> 
            <div id="requirement-count" style="height:100%;width:100%" class="card-tm p-3 animated fadeInUp">
            
            </div>
        </div>
        
        
        <!-- col 1 End ### -->
        <!-- col 2 -->
        
        <div class="col-md-4 p-2"> 
            <div id="testCase-count" style="height:100%;width:100%" class="card-tm p-3 animated fadeInUp">
            
            </div>
        </div>
        
        <!-- col 2 End ### -->
        <!-- col 3 -->
        
         <div class="col-md-4 p-2"> 
            <div id="incident-count" style="height:100%;width:100%" class="card-tm p-3 animated fadeInUp">
            
            </div>
        </div>
        
        
        <!-- col 3 End ### -->
   
        <!-- col Release -->
          <div class="col-md-12 p-2"> 
            <div style="height:100%;width:100%" class="card-tm p-3 animated fadeInUp">
            	<div class="d-flex" style="width:100%;height:100%">
            		<!-- col-1 -->
            		<div id="releaseCountGraph" style="width:30%;height:100%">
            		
            		</div>
            		<!-- col-1 END ###-->
            		
            		<!-- col-2 -->
            		<div id="sprintCountGraph" style="width:70%;height:100%">
            		
            		</div>
            		<!-- col-2 END ###-->
            	</div>
            	<div></div>
            </div>
		 </div>
        <!-- col Release End ### -->
    </div>
    
   	<div class="row m-0 p-0">
        <div class="col-md-6 p-2"> 
            <div style="height:100%;width:100%" class="card-tm p-3  animated fadeInRight" >

            	   
            	<div  id="overLayOne" style="height:100%;width:100%;">
	                
	            </div>
	               
	         </div>

        </div>
        
         <div class="col-md-6 p-2"> 
            <div style="height:100%;width:100%" class="card-tm p-5  animated fadeInRight" >

            	   
            	<div  id="" style="height:100%;width:100%;">
	                
	            </div>
	               
	         </div>

        </div>
    </div>
	
	`;
	
		 workspace.innerHTML=htmlToRender;
		 
		 
		 reqAllFilter();
		 
		 testCaseAllFilter();
		 
		 incidentAllFilter();
		 

		 
		 /*MAIN KPIS*/
		 
			 genratesProjectProgressReport();
			 incidnetReport();
			 liveUpdateDashbaordRenderedGraphs();
			 initDataToogle();
}

initDataToogle();
function initDataToogle(){
	$('[data-toggle="tooltip"]').tooltip();
}


function checkSelection(selectedElemenet){
	let projectId;
	if(selectedElemenet.checked){
	projectId = selectedElemenet.getAttribute('data-dataobject');
	if(!projectActiveFilter.contains(projectId)){
		projectActiveFilter.push(projectId);
		let tempName = selectedElemenet.getAttribute('data-name');
		toggleNotification(` ✔️ ${tempName} has been add. Click on Filter to Update Data`,'info');
	}
	
	}else{
	projectId = selectedElemenet.getAttribute('data-dataobject');	
		
		if(projectActiveFilter.contains(projectId)){
			let tempIndexStorage = projectActiveFilter.indexOf(projectId);
			projectActiveFilter.remove(tempIndexStorage,tempIndexStorage);
			let tempName = selectedElemenet.getAttribute('data-name');
			toggleNotification(` ✖️  ${tempName.toUpperCase()} has been removed. Click on Filter To Update Data`,'info');
		}
		
	}
	
}

 