
 window.onload = function() {
    sideBarDisplay();
  };
  

function sideBarDisplay(){
	let sideBar = `<div class="logo_content">
  <div class="logo">
     <h8>Total Orders : 500 <br></h8>
     <h8>Total Profit : 500 <br></h8>
     <h8>Total Saved : 500 <br></h8>
   <ul class="nav_list">
    <li>
      <a href="#"><i class="fas fa-th"></i>      
        <span class="links_name">Dashboard</span>
      </a>
       <span class="tooltip">Dashboard</span> 
      </li>
      <li>
        <a href="#"><i class="fas fa-user-friends"></i>     
          <span class="links_name">Users</span>
        </a>
         <span class="tooltip">Users</span> 
        </li>    <li>
          <a href="#"><i class="fas fa-comment-alt"></i>      
            <span class="links_name">Messages</span>
          </a>
           <span class="tooltip">Messages</span> 
          </li>    <li>
            <a href="#"><i class="fas fa-chart-bar"></i>      
              <span class="links_name">Analytics</span>
            </a>
             <span class="tooltip">Analytics</span> 
            </li>    <li>
              <a href="/indoUser/stores" ><i class="fas fa-store"></i>      
                <span class="links_name">Store</span>
              </a>
               <span class="tooltip">Store</span> 
              </li>    <li>
                <a href="#"><i class="fas fa-shopping-cart"></i>      
                  <span class="links_name">Orders</span>
                </a>
                 <span class="tooltip">Orders</span> 
                </li>    <li>
                  <a href="#"><i class="fas fa-heart"></i>      
                    <span class="links_name">Saved</span>
                  </a>
                   <span class="tooltip">Saved</span> 
                  </li>    <li>
                    <a href="#"><i class="fas fa-cog"></i>      
                      <span class="links_name">Settings</span>
                    </a>
                     <span class="tooltip">User Profile Settings</span> 
                    </li>  
   </ul>
  </div>
</div>`;

 document.getElementById("sidebar").innerHTML = sideBar;
}


/*function StoresDashBoard(){
let storeData = `
	          <div class="row">
            <div class="col-md-12">
          <div class="card">HERE WE WILL ADD OUR SEARCH AND SORTING FILTERS </div>
                   </div>
                  </div>
                  </div>

	 <div class="row">
            <div class="col-md-12">
          <div class="listofStores" id="listofStores">


</div>
                   </div>
                  </div>
                  </div>


	`;
document.getElementById("workSpace").innerHTML = storeData;
}
*/

