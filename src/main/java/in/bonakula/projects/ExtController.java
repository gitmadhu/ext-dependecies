package in.bonakula.projects;

import in.bonakula.projects.data.Extensions;
import in.bonakula.projects.dto.Dependency;
import in.bonakula.projects.service.ExtensionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/extensions")
public class ExtController {
    @Resource
    ExtensionsService extensionsService;
    @GetMapping
    public List getAllExtensions(){
        return extensionsService.getAllExtensions();
    }

    @GetMapping("/details/{extname}")
    public Extensions getExtensionDetailsByName(@PathVariable  String extname){
        return extensionsService.getExtensionsByName(extname);
    }

    @GetMapping("/info")
    public String getExtensionsInfo(){
        String info = " Extensions in dependency order  options: \n" +
                "     @deprecated: is deprecated, \n " +
                "     p: platform extension, \n" +
                "     *: auto-required \n" +
                "     ?: lazy-loaded, \n" +
                "     i: got items.xml, \n" +
                "     b: got beans.xml, \n" +
                "     c: got core module \n" +
                "     w: got web module ) \n";
        return info;
    }




    @GetMapping("/{extname}")
    public Dependency getExtensionByName(@PathVariable  String extname){
        Set<String> dependencies  = new HashSet<>();
        Dependency dependency = new Dependency();
        if(extname.contains(",")){
            String[] extensions = extname.split(",");
            List<String> extList = Arrays.asList(extensions);
            for (String ext: extList){
                Extensions depList = extensionsService.getExtensionsByName(ext);
                getDepList(dependencies, depList);
            }
        }else {
            Extensions ext = extensionsService.getExtensionsByName(extname);
            getDepList(dependencies,ext);
        }
        dependency.setDependencies(dependencies);
        dependency.setTotal(dependencies.size());
        return dependency;
    }

    private void getDepList(Set<String> dependencies, Extensions depList) {
        if(depList!= null && depList.getDep() != null && depList.getDep().length() > 0){
            if(depList.getDep().contains(",")){
                String[] split = depList.getDep().split(",");
                dependencies.addAll(Arrays.asList(split));
            }else {
                dependencies.add(depList.getDep());
            }
        }
    }
}
