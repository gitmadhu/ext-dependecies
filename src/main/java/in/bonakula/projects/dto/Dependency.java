package in.bonakula.projects.dto;

import lombok.Data;

import java.util.Set;

@Data
public class Dependency {
    private Set<String> dependencies;
    private int total;
}
