Ext.require([
    'Ext.form.*',
    'Ext.tip.*'
]);
Ext.ns('Rdp.demo');

Rdp.demo.xgrid = {
    
    init: function(){
        Rdp.demo.xgrid.model();
        Rdp.demo.xgrid.remote();
    },
    
    model: function(){
        Ext.define('District', {
            extend: 'Ext.data.Model',
            fields: [
                 {name:'id', mapping:'id', type:'int'},
                 {name:'nameEn', mapping:'nameEn', type:'string'},
                 {name:'nameBn', mapping:'nameBn', type:'string'}
            ],
            validations:[
                {type:'lenght', field:'nameEn', min:2},
                {type:'format', field:'nameEn', matcher:/^[\w\d,.#:\-/ ]{2,45}$/},
                {type:'format', field:'nameBn', matcher: /^[\p{InBengali}\u0964,.#:\-/ ]{0,60}$/}
            ]
        });

        Ext.define('Thana', {
            extend: 'Ext.data.Model',
            fields: [
                 {name:'id', mapping:'id', type:'int'},
                 {name:'nameEn', mapping:'nameEn', type:'string'},
                 {name:'nameBn', mapping:'nameBn', type:'string'}
            ],
            validations:[
                {type:'lenght', field:'nameEn', min:2},
                {type:'format', field:'nameEn', matcher:/^[\w\d,.#:\-/ ]{2,45}$/},
                {type:'format', field:'nameBn', matcher: /^[\p{InBengali}\u0964,.#:\-/ ]{0,60}$/}
            ]
        });
    },
    
    remote: function(){
        Ext.Ajax.request({
            url: 'mstore',
            method: 'get',
            timeout: 60000,
            success: function(response, request){
                var text = response.responseText;
                var json = Ext.JSON.decode(text);
                Rdp.demo.xgrid.draw(json);          
            },
            failure: function(results, request){
                Ext.Msg.alert("Error","Unable to render form!");
            }
        });
    },
        
    draw: function(json){        
        Ext.QuickTips.init();
        
        var districts = new Ext.data.Store({
            model:'District',
            idProperty:'id',
            autoLoad:true,
            data:json,
            proxy: {
                type: 'memory',
                reader:{
                    type:'json',
                    root:'districts'
                }
            }
        });
                
        var thanas = new Ext.data.Store({
            model:'Thana',
            idProperty:'id',
            autoLoad:true,
            data:json,
            proxy: {
                type: 'memory',
                reader:{
                    type:'json',
                    root:'thanas'
                }
            }
        });
        
        
        var dist = new Ext.form.ComboBox({
            fieldLabel:'District',
            name:'cmb-DBs',
            forceSelection: true,
            store: districts,
//            initComponent:function(){
//                //TODO
//            },
            emptyText:'SELECT',
            triggerAction: 'all',			
            editable:false,
            displayField:'nameEn',
            valueField:'id',
            hiddenName:'id'
        });
        
        var than = new Ext.form.ComboBox({
            fieldLabel:'Thana',
            name:'cmb-DBs',
            forceSelection: true,
            store: thanas,
            emptyText:'SELECT',
            triggerAction: 'all',			
            editable:false,
            displayField:'nameEn',
            valueField:'id',
            hiddenName:'id'
        });
                                        
        var win=new Ext.Window({
            title: 'Grid example',
            tooltip: 'Gender',
            bodyStyle:'padding: 10px',
            width:400,
            height:360,
            items:[dist, than],			
            layout:'form'
        });
        win.show();
    }
}

Ext.onReady(Rdp.demo.xgrid.init, Rdp.demo.xgrid);