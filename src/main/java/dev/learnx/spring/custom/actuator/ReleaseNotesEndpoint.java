package dev.learnx.spring.custom.actuator;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Endpoint(id = "release-notes")
public class ReleaseNotesEndpoint {

    Map<String, List<String>> releaseNotes = new HashMap<>();

    @PostConstruct
    public void constructReleaseNotes(){
        releaseNotes.put("0.0.1-SNAPSHOT", Stream.of("Creating Sample Spring-Boot Project",
                "Adding Spring Boot Actuator Capabilities").collect(Collectors.toList()));
        releaseNotes.put("0.0.2-SNAPSHOT", Stream.of("Converting application to Docker",
                "Pushing Build to Container Registry").collect(Collectors.toList()));
    }

    @ReadOperation
    public Map<String, List<String>> getReleaseNotes(){
        return releaseNotes;
    }

    @ReadOperation
    public List<String> getReleaseNotesForVersion(@Selector String version){
        return releaseNotes.get(version);
    }

    @WriteOperation
    public void addReleaseNotesForVersion(@Selector String version, String releaseNotes){
        this.releaseNotes.put(version, Arrays.asList((releaseNotes.split(","))));
    }

    @DeleteOperation
    public void removeReleaseNotes(@Selector String version){
        this.releaseNotes.remove(version);
    }
}
