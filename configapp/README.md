# Overview
Config Update App based on BundleActivator, no Blueprint

## Remarks
1. Bundle symbolic name must not be `configadmin`
2. Config PID must be set in a file named as the Config PID and with .cfg extension, e.g ConfigApp.cfg 
3. In code, be careful of whether using `Constants.SERVICE_PID` (correct) or `Constants.SERVICE_ID` (not correct)

## Additional notes
1. Can add a metatype XML file in `src/main/resources/OSGI-INF/metatype` in which we declare meta data for the config pid for the bundle to bind with. This help give additional explanation about the configuration item. The file name must be same as configuration item PID, but all lowercase