Ext.ns('com.rdpgroupbd.demo');
com.rdpgroupbd.demo.Dyngrid = {
    init: function(){
               
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
                        
        var grid = new Ext.grid.Panel({
            height:300,
            title:'District List',
            store:store,
            loadMask:true,
            disableSelection:true,
            invalidateScrollerOnRefresh:false,
            viewConfig: {
                trackOver:false
            },
            columns:[
                {xtype:'rownumberer', width:40, sortable:false},
                {id:'id', text: "ID", dataIndex: 'id', flex: 1, sortable: false},
                {id:'nameEn', text: "Name [EN]", dataIndex: 'nameEn', width: 130, sortable:false},
                {id:'nameBn', text: "Name [BN]", dataIndex: 'nameBn', width: 130, sortable:false}
            ]
        });

        var win=new Ext.Window({
            title: 'Grid example',
            width:400,
            height:360,
            items: [grid],			
            layout:'fit'
        });
        win.show();
    }	
}

Ext.onReady(com.rdpgroupbd.demo.Dyngrid.init, com.rdpgroupbd.demo.Dyngrid);