
if(async_load[?"type"] != "GooglePlayPassLicensing")
	exit

show_debug_message("GooglePlayPassLicensing ASYNC ---> " + json_encode(async_load))

status = async_load[?"event"]

switch(async_load[?"event"])
{
	case GooglePlayPassLicensing_Licensed:
	break
	
	case GooglePlayPassLicensing_NotLicensed:
	break
	
	case GooglePlayPassLicensing_Error:
	break
}
