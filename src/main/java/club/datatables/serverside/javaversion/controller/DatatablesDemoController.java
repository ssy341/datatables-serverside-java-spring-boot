package club.datatables.serverside.javaversion.controller;

import club.datatables.serverside.javaversion.dao.DatatablesDemoRepository;
import club.datatables.serverside.javaversion.entity.DatatablesDemo;
import club.datatables.serverside.javaversion.vo.DatatablesDemoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;


/**
 * @author Datatables中文网 http://datatables.club
 * @date 2020年09月08日14:37:27
 *
 * 控制器
 */
@Controller
public class DatatablesDemoController {

    @Autowired
    DatatablesDemoRepository empRepository;


    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }


    @RequestMapping(value = "/extn")
    public String extn(Model model) {
        return "extn";
    }


    /**
     * 客户端模式
     * @return
     */
    @RequestMapping(value = "/clientside", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesOutput<DatatablesDemo> clientside() {
        List<DatatablesDemo> list = empRepository.findAll();
        DataTablesOutput out = new DataTablesOutput<DatatablesDemo>();
        out.setData(list);
        return out;
    }

    /**
     * 服务端模式
     * @param input
     * @return
     */
    @RequestMapping(value = "/dtlist", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesOutput<DatatablesDemo> list(@Valid DataTablesInput input) {
        return empRepository.findAll(input);
    }


    @RequestMapping(value = "/dtlist", method = RequestMethod.POST)
    @ResponseBody
    public DataTablesOutput<DatatablesDemo> datatables(@Valid @RequestBody DataTablesInput dataTablesInput) {
        DataTablesOutput output = empRepository.findAll(dataTablesInput);
        return output;
    }

    /**
     * 带更多参数
     * @param input
     * @return
     */
    @RequestMapping(value = "/dtlist-extn", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesOutput<DatatablesDemo> listExtn(@Valid DataTablesInput input) {
        DataTablesOutput output = new DataTablesOutput();
        try{
//            int i = 1/0;
            output = empRepository.findAll(input);
            List<DatatablesDemo> list = output.getData();
            List<DatatablesDemoVo> listVos = new ArrayList<>();
            list.stream().forEach(
                    d->{
                        DatatablesDemoVo tmp = new DatatablesDemoVo();

                        BeanUtils.copyProperties(d,tmp);
                        //设置id
                        tmp.setRowId(UUID.randomUUID().toString());

                        //设置class
                        if(tmp.getAge()>40){
                            tmp.setRowClass("orange");
                        }

                        //设置对象
                        Map<String,String> obj = new HashMap<>();
                        obj.put("extn",tmp.getExtn());
                        obj.put("email",tmp.getEmail());
                        tmp.setRowData(obj);


                        //设置属性
                        if(tmp.getAge()>60){
                            Map<String,String> attr = new HashMap<>();
                            attr.put("flag","fired");
                            tmp.setRowAttr(attr);
                        }
                        listVos.add(tmp);
                    }
            );
            output.setData(listVos);
        }catch (Exception e){
            output.setError("出错啦，请联系开发341");
            e.printStackTrace();
        }
        return output;
    }
}
