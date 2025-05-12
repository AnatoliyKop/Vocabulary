package ait.cohort55.wortebuch.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class AddWordDto {
    private String original;
    private String translation;
    private List<String> usageExample;
}
