package cc.example.rookie.service.impl

import cc.example.rookie.entity.Brand
import cc.example.rookie.repository.BrandRepository
import cc.example.rookie.service.BrandService
import org.springframework.stereotype.Service
import javax.annotation.Resource

@Service
class BrandServiceImpl : BrandService {

    @Resource
    lateinit var brandRepository : BrandRepository

    override fun save(brand: Brand): Brand {
        return brandRepository.save(brand)
    }

    override fun findById(id: Int): Brand? {
        return brandRepository.findById(id).get()
    }

    override fun existsById(id: Int): Boolean {
        return brandRepository.existsById(id)
    }

    override fun findAllByClassifyId(classifyId: Int): List<Brand> =
            brandRepository.findAllByClassify(classifyId)

    override fun findAll(): List<Brand> = brandRepository.findAll()
}