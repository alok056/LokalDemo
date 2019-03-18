package com.lokal.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleBO {
    private Article article;
    private List<Category> categories;
    private List<String> locations;
    private List<String> tags;
    private List<String> authors;
}
