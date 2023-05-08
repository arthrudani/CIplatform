function display_c(){
	var refresh=1000; // Refresh rate in milli seconds
    mytime=setTimeout('display_ct()',refresh)
}
function display_ct() {
	const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
	const days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];  
    var x = new Date()
    let fdate=days[x.getDay()]+" "+months[x.getMonth()]+" "+x.getDate()+", "+x.getFullYear()+", "+x.toLocaleString('en-US', { hour: 'numeric', minute: 'numeric', hour12: true });
    $("#ct").html(fdate);
    display_c();
}