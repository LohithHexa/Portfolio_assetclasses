package com.portfolio.management.controller;

import com.portfolio.management.entity.AssetClass;
import com.portfolio.management.service.AssetClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/asset-classes")
public class AssetClassController {

    @Autowired
    private AssetClassService service;

    @GetMapping
    public List<AssetClass> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AssetClass getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public AssetClass create(@RequestBody AssetClass assetClass) {
        return service.save(assetClass);
    }

    @PutMapping("/{id}")
    public AssetClass update(@PathVariable Long id, @RequestBody AssetClass updatedAsset) {
        AssetClass existing = service.getById(id);
        if (existing != null) {
            updatedAsset.setId(id); 
            return service.save(updatedAsset);
        }
        return null; 
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
