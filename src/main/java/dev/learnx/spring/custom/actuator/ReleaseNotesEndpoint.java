package dev.learnx.spring.custom.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
}
