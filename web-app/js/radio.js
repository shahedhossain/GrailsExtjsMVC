Ext.ns('Rdp.demo');
Rdp.demo.radio = {
    
    init: function(){        
        Ext.Ajax.request({
            url: 'store',
            method: 'get',
            timeout: 60000,
            success: function(response, request){
                var text = response.responseText;
                var list = Ext.decode(text).data;
                Rdp.demo.radio.draw(list);                
            },
            failure: function(results, request){
                Ext.Msg.alert("Error","Unable to render form!");
            }
        });        
    },
    
    draw: function(list){
        
        var remote = {
            store: function(){
                var robj = [];                
                for(var j in list){
                    var obj = new Ext.form.field.Radio({
                        boxLabel:list[j].nameEn,
                        name:'sex',
                        inputValue:list[j].id,
                        checked:list[j].id==1
                    });
                    robj.push(obj);
                }               
                return robj;
            }
        }
        
        var radio = new Ext.form.RadioGroup({
            fieldLabel:'Gender',
            colums: 2,
            vertical: true,
            items: remote.store()
        });
                                
        var win=new Ext.Window({
            title: 'Grid example',
            bodyStyle:'padding: 10px',
            width:400,
            height:360,
            items:[radio],			
            layout:'form'
        });
        win.show();
    }
}

Ext.onReady(Rdp.demo.radio.init, Rdp.demo.radio);