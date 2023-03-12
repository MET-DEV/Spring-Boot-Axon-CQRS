package com.metsoft.cqrsarticleproject.controller.commandController;

import com.metsoft.cqrsarticleproject.command.CreateBookCommand;
import com.metsoft.cqrsarticleproject.dto.CreateBookDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookCommandController {
    private final CommandGateway commandGateway;
    private final ModelMapper modelMapper;

    public BookCommandController(CommandGateway commandGateway, ModelMapper modelMapper) {
        this.commandGateway = commandGateway;
        this.modelMapper = modelMapper;
    }
    @PostMapping
    public void save(@RequestBody CreateBookDto bookDto){
        CreateBookCommand bookCommand=modelMapper.map(bookDto, CreateBookCommand.class);
        bookCommand.setId(UUID.randomUUID().toString());
        commandGateway.sendAndWait(bookCommand);
    }

}
