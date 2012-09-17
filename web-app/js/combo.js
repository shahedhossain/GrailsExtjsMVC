Ext.ns('com.rdpgroupbd.demo');
com.rdpgroupbd.demo.Dyncombo = {
    init: function(){
        var data=['Code Igniter','Cake Php','Symfony','Zend'];
        var comboLocal =new Ext.form.ComboBox({
            fieldLabel:'Frameworks PHP',
            name:'cmb-data',
            forceSelection:true,
            store:data,
            emptyText:'Select a framework...',
            triggerAction: 'all',
            editable:false				
        });		

        var store= new Ext.data.Store({
            fields: [
                {name:'id', mapping:'id', type:'int'},
                {name:'nameEn', mapping:'nameEn', type:'string'},
                {name:'nameBn', mapping:'nameBn', type:'string'}
            ],
            idProperty:'id',
            autoLoad:true,
            proxy: {
                type:'ajax',
                url:'store',
                reader:{
                    type:'json',
                    root:'data',
                    totalProperty: 'num'
                }
            }
        });
                        
        var comboRemote=new Ext.form.ComboBox({
            fieldLabel:'Data Base',
            name:'cmb-DBs',
            forceSelection: true,
            store: store,
            emptyText:'pick one DB...',
            triggerAction: 'all',			
            editable:false,
            displayField:'nameEn',
            valueField:'id',
            hiddenName:'id'
        });

        var win=new Ext.Window({
            title: 'ComboBox example',
            bodyStyle:'padding: 10px',
            width:400,
            height:360,
            items: [comboLocal, comboRemote],			
            layout:'form'
        });
        win.show();
    }	
}

Ext.onReady(com.rdpgroupbd.demo.Dyncombo.init, com.rdpgroupbd.demo.Dyncombo);