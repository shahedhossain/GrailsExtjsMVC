Ext.Loader.setConfig({enabled:true}); 
Ext.application
({
    name: 'Ext4Example', 
    appFolder: '${appFolder}',
    controllers: [
        'Users'
    ],
 
    autoCreateViewport: true
});