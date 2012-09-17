Ext.require([
    'Ext.form.*',
    'Ext.tip.*'
]);
Ext.ns('Rdp.demo');
Rdp.demo.xgrid = {
    
    init: function(){
        Ext.Ajax.request({
            url: 'store',
            method: 'get',
            timeout: 60000,
            success: function(response, request){
                var text = response.responseText;
                var json = Ext.decode(text);
                Rdp.demo.xgrid.draw(json);                
            },
            failure: function(results, request){
                Ext.Msg.alert("Error","Unable to render form!");
            }
        });                                
    },
    
    draw: function(json){
        Ext.QuickTips.init();
        var store = new Ext.data.Store({
            fields: [
                {name:'id', mapping:'id', type:'int'},
                {name:'nameEn', mapping:'nameEn', type:'string'},
                {name:'nameBn', mapping:'nameBn', type:'string'}
            ],
            idProperty:'id',
            autoLoad:true,
            data:json,
            proxy: {
                type: 'memory',
                reader:{
                    type:'json'
//                    root:'data',
//                    totalProperty: 'num'
                }
            }
        });
        
        var remote = {
            items: function(){
                var robj = [];                
                store.each(function(record){
                    var obj = new Ext.form.field.Radio({
                        boxLabel:record.data.nameEn,
                        name:'sex',
                        inputValue:record.data.id,
                        checked:record.data.id==3
                    });
                    robj.push(obj);
                });              
                return robj;
            }
        }
        
        var radio = new Ext.form.RadioGroup({
            fieldLabel:'Gender',
            colums: 2,
            vertical: true,
            items: remote.items()
        });
                                
        var win=new Ext.Window({
            title: 'Grid example',
            tooltip: 'Gender',
            bodyStyle:'padding: 10px',
            width:400,
            height:360,
            items:[radio],			
            layout:'form'
        });
        win.show();
    }
}

Ext.onReady(Rdp.demo.xgrid.init, Rdp.demo.xgrid);