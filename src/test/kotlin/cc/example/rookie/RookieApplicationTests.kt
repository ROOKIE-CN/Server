package cc.example.rookie

import cc.example.rookie.entity.Brand
import cc.example.rookie.entity.Classify
import cc.example.rookie.entity.Model
import cc.example.rookie.entity.User
import cc.example.rookie.repository.ModelRepository
import cc.example.rookie.repository.UserRepository
import cc.example.rookie.service.ClassifyService
import cc.example.rookie.service.UserService
import cc.example.rookie.util.Captcha
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.SimpleJpaRepository
import java.util.*
import java.util.stream.Stream
import javax.annotation.Resource

@SpringBootTest
class RookieApplicationTests {



	@Resource
	lateinit var userService : UserService

	@Resource
	lateinit var classifyService: ClassifyService

	@Resource
	lateinit var modelRepository : ModelRepository

	@Test
	fun test(){
		for (i in (0..10)){
			val result = userService.register("15233478974")
			println(result)
		}

	}



	@Test
	fun userTest(){
//		val list = modelRepository.findByClassifyAndBrandAndModelName(1, 1, "三星")
		val objectMapper = ObjectMapper()
	}

	val objectMapper = ObjectMapper()


	@Test
	fun  jsonTest(){

//		val json = "{\"code\":\"0\",\"labelList\":[{\"category\":\"36\",\"categoryName\":\"手机\",\"categoryPhotoName\":\"JIX3vFrm0ZNhpJeX24Vx.png\",\"categoryPhotoPath\":\"/product/virtualCategory/\",\"labelContentList\":[{\"displayName\":\"价格区间\",\"fieldName\":\"price_range\",\"itemEntryList\":[{\"key\":\"0\",\"value\":\"0-999\"},{\"key\":\"1\",\"value\":\"1000-1999\"},{\"key\":\"2\",\"value\":\"2000-3999\"},{\"key\":\"3\",\"value\":\"4000-5999\"},{\"key\":\"4\",\"value\":\"6000及以上\"}]},{\"displayName\":\"屏幕尺寸\",\"fieldName\":\"screen_size\",\"itemEntryList\":[{\"key\":\"2\",\"value\":\"6.0-6.5英寸\"},{\"key\":\"3\",\"value\":\"6.5英寸以上\"}]},{\"displayName\":\"运行内存\",\"fieldName\":\"ram\",\"itemEntryList\":[{\"key\":\"1\",\"value\":\"4GB\"},{\"key\":\"2\",\"value\":\"6GB\"},{\"key\":\"3\",\"value\":\"8GB及以上\"}]},{\"displayName\":\"存储容量\",\"fieldName\":\"rom\",\"itemEntryList\":[{\"key\":\"1\",\"value\":\"64GB\"},{\"key\":\"2\",\"value\":\"128GB\"},{\"key\":\"3\",\"value\":\"256GB及以上\"}]},{\"displayName\":\"上市时间\",\"fieldName\":\"market_time\",\"itemEntryList\":[{\"key\":\"0\",\"value\":\"3个月内\"},{\"key\":\"1\",\"value\":\"3-6个月\"},{\"key\":\"2\",\"value\":\"6个月以上\"}]}]}],\"pageNum\":1,\"pageSize\":20,\"resultList\":[{\"activeBeginTime\":\"2020-10-30 10:08:00\",\"activeEndTime\":\"2020-10-30 12:00:00\",\"briefName\":\"【100元订金预订】HUAWEI Mate 40 Pro\",\"buttonMode\":\"25\",\"displayTags\":\"新品上市\",\"goodRate\":\"100\",\"isInv\":0,\"mobileVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/222f70315285890809152786180/v.f118461.mp4\",\"name\":\"【100元订金预订】HUAWEI Mate 40 Pro\",\"photoName\":\"AFC179E0F69ADCA5310E473170896895376AC63839325375mp.png\",\"photoPath\":\"/product/6941487207169/\",\"picture3DPath\":\"\",\"priceLabel\":1,\"priceMode\":2,\"productId\":10086215757168,\"promoLabels\":[\"赠送积分\"],\"promotionInfo\":\"享多重权益\",\"rateCount\":0,\"skuCode\":\"2601010232301\",\"skuCount\":10,\"skuName\":\"【100元订金预订】HUAWEI Mate 40 Pro 5G 全网通 8GB+256GB（亮黑色）\",\"tagBgColor\":\"FF6A6E\",\"webVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/222f70315285890809152786180/v.f118461.mp4\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI Mate 40 RS保时捷设计\",\"buttonMode\":\"7\",\"displayTags\":\"新品上市\",\"goodRate\":\"100\",\"isInv\":0,\"mobileVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/21e3e18e5285890809152740871/v.f118461.mp4\",\"name\":\"HUAWEI Mate 40 RS保时捷设计\",\"photoName\":\"88D5AE26F960AA9D7134C810FFF0190E39A87B6316E619B7mp.png\",\"photoPath\":\"/product/6941487207664/\",\"picture3DPath\":\"\",\"priceLabel\":1,\"priceMode\":2,\"productId\":10086918242357,\"promoLabels\":[\"赠送积分\"],\"promotionInfo\":\"\",\"rateCount\":0,\"skuCode\":\"2601010233403\",\"skuCount\":6,\"skuName\":\"HUAWEI Mate 40 RS保时捷设计 5G 全网通 12GB+512GB（陶瓷黑）\",\"tagBgColor\":\"FF6A6E\",\"webVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/21e3e18e5285890809152740871/v.f118461.mp4\"},{\"activeBeginTime\":\"2020-10-30 10:08:00\",\"activeEndTime\":\"2020-10-30 12:00:00\",\"briefName\":\"【100元订金预订】HUAWEI Mate 40 Pro+\",\"buttonMode\":\"25\",\"displayTags\":\"新品上市\",\"goodRate\":\"100\",\"isInv\":0,\"mobileVideoPath\":\"\",\"name\":\"【100元订金预订】HUAWEI Mate 40 Pro+\",\"photoName\":\"64A6BB5D9B19C61B2C8724E1D12E02E0DF740091C034401Bmp.png\",\"photoPath\":\"/product/6941487207626/\",\"picture3DPath\":\"\",\"priceLabel\":1,\"priceMode\":2,\"productId\":10086250925335,\"promoLabels\":[\"赠送积分\"],\"promotionInfo\":\"享多重权益\",\"rateCount\":0,\"skuCode\":\"2601010232201\",\"skuCount\":2,\"skuName\":\"【100元订金预订】HUAWEI Mate 40 Pro+ 5G 全网通 12GB+256GB（陶瓷黑）\",\"tagBgColor\":\"FF6A6E\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI P40\",\"buttonMode\":\"1\",\"goodRate\":\"98\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"HUAWEI P40\",\"photoName\":\"0927F13E5805FD0FBD065F528D4099ECC6C81DDA5B9E07FAmp.png\",\"photoPath\":\"/product/6901443381340/\",\"picture3DPath\":\"/display/10086013232739/496D5B3FACED8D6EDF147220F0E493D641523326D2554EFB.zip\",\"price\":4188.0,\"priceAccurate\":4188.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086013232739,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"赠送积分\"],\"promotionInfo\":\"预订享多重优惠\",\"rateCount\":20394,\"skuCode\":\"2601010188314\",\"skuCount\":15,\"skuName\":\"HUAWEI P40 5G 全网通 6GB+128GB（零度白）\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI P40 Pro\",\"buttonMode\":\"1\",\"goodRate\":\"98\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"HUAWEI P40 Pro\",\"photoName\":\"0410C56E4DFF825A527CBD3369F4D394F1699311CF51F864mp.png\",\"photoPath\":\"/product/6901443381517/\",\"picture3DPath\":\"/display/10086715691479/75E2C10098E6094C7596F85F582EF290BB7FB3A8C20C7EE1.zip\",\"price\":5988.0,\"priceAccurate\":5988.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086715691479,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"分期免息\",\"赠送积分\"],\"promotionInfo\":\"预订享多重权益\",\"rateCount\":42636,\"skuCode\":\"2601010188703\",\"skuCount\":16,\"skuName\":\"HUAWEI P40 Pro 5G 全网通 8GB+128GB（零度白）\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI Mate 30 Pro 5G\",\"buttonMode\":\"1\",\"goodRate\":\"98\",\"isInv\":1,\"mobileVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/001774685285890795459358887/v.f20.mp4\",\"name\":\"HUAWEI Mate 30 Pro 5G\",\"photoName\":\"1D8C064B860EB5FB2671030543964FB219AEF79AABC06D2Dmp.png\",\"photoPath\":\"/product/6901443353149/\",\"picture3DPath\":\"/display/10086775311605/6E95A4A775A8532EB5365EBC2363D1799A713B41FFF31A21.zip\",\"price\":5899.0,\"priceAccurate\":5899.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086775311605,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"分期免息\",\"赠送积分\"],\"promotionInfo\":\"领券减100|6期免息\",\"rateCount\":64779,\"skuCode\":\"2601010161225\",\"skuCount\":15,\"skuName\":\"HUAWEI Mate 30 Pro 5G 全网通 8GB+128GB 麒麟990 双4000万徕卡电影四摄（翡冷翠）\",\"webVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/001774685285890795459358887/v.f20.mp4\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI Mate 30 5G\",\"buttonMode\":\"1\",\"goodRate\":\"98\",\"isInv\":0,\"mobileVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/7dc4e37c5285890796067095935/v.f20.mp4\",\"name\":\"HUAWEI Mate 30 5G\",\"photoName\":\"34DCC76348E355DB165E28793093761C2D9B8A9E1FFA9F3Amp.png\",\"photoPath\":\"/product/6901443353408/\",\"picture3DPath\":\"/display/10086238753372/9A13DA3D18B1E379C58A93D776749D010FE85E39FE02FA21.zip\",\"price\":4499.0,\"priceAccurate\":4499.0,\"priceLabel\":1,\"priceMode\":1,\"productId\":10086238753372,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"赠送积分\"],\"promotionInfo\":\"限量赠好礼\",\"rateCount\":49318,\"skuCode\":\"2601010158612\",\"skuCount\":1,\"skuName\":\"HUAWEI Mate 30 5G 全网通 8GB+128GB 麒麟990 4000万超感光徕卡三摄（青山黛）\",\"webVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/7dc4e37c5285890796067095935/v.f20.mp4\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI Mate 30 RS 保时捷设计\",\"buttonMode\":\"1\",\"goodRate\":\"99\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"HUAWEI Mate 30 RS 保时捷设计\",\"photoName\":\"484D42DB83550E7CF59813E6BE3E2A9A4CF07CF0E75E32A3mp.png\",\"photoPath\":\"/product/6901443353347/\",\"picture3DPath\":\"\",\"price\":12999.0,\"priceAccurate\":12999.0,\"priceLabel\":1,\"priceMode\":1,\"productId\":10086374426533,\"promoLabels\":[\"赠送积分\"],\"promotionInfo\":\"\",\"rateCount\":5695,\"skuCode\":\"2601010167401\",\"skuCount\":2,\"skuName\":\"HUAWEI Mate 30 RS 保时捷设计 5G全网通 12GB+512GB（玄黑）\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI nova 7 SE 5G 活力版\",\"buttonMode\":\"10\",\"displayTags\":\"新品上市\",\"goodRate\":\"97\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"HUAWEI nova 7 SE 5G 活力版\",\"photoName\":\"216F9FDF0D48F497D8DFA2ABAC4FE07DB218209AA7389AB5mp.png\",\"photoPath\":\"/product/6901443418442/\",\"picture3DPath\":\"\",\"price\":2299.0,\"priceAccurate\":2299.0,\"priceLabel\":1,\"priceMode\":1,\"productId\":10086938832551,\"promoLabels\":[\"商品赠券\",\"赠送积分\"],\"promotionInfo\":\"预订立省50元\",\"rateCount\":421,\"skuCode\":\"2601010231501\",\"skuCount\":4,\"skuName\":\"HUAWEI nova 7 SE 5G 活力版 8GB+128GB 全网通版（银月星辉）\",\"tagBgColor\":\"FF6A6E\",\"tagPhotoName\":\"tU9nY5qxo0Okt4LpxxIy.png\",\"tagPhotoPath\":\"/tag/188/\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"2020-10-23 00:00:00\",\"activeEndTime\":\"2020-10-30 17:30:00\",\"briefName\":\"【100元订金预订】HUAWEI Mate 30E Pro\",\"buttonMode\":\"22\",\"displayTags\":\"新品上市\",\"goodRate\":\"100\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"【100元订金预订】HUAWEI Mate 30E Pro\",\"photoName\":\"02CAB92CA3E7CA5A99995191A776C00D87C32CC39A4B1605mp.png\",\"photoPath\":\"/product/6901443415670/\",\"picture3DPath\":\"\",\"priceLabel\":1,\"priceMode\":2,\"productId\":10086733307032,\"promoLabels\":[\"赠送积分\"],\"promotionInfo\":\"尊享多重权益\",\"rateCount\":0,\"skuCode\":\"2601010232101\",\"skuCount\":12,\"skuName\":\"【100元订金预订】HUAWEI Mate 30E Pro 5G 全网通 8GB+128GB（亮黑色）\",\"tagBgColor\":\"FF6A6E\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"华为畅享20 Plus 5G\",\"buttonMode\":\"1\",\"goodRate\":\"96\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"华为畅享20 Plus 5G\",\"photoName\":\"945B5EDC4DEF7252145D4D12713FD7C98208F1F5B3026C9Cmp.png\",\"photoPath\":\"/product/6941487202300/\",\"picture3DPath\":\"\",\"price\":2299.0,\"priceAccurate\":2299.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086842408658,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"赠送积分\"],\"promotionInfo\":\"预订省50|赠耳机\",\"rateCount\":1170,\"skuCode\":\"2601010230408\",\"skuCount\":8,\"skuName\":\"华为畅享20 Plus 5G 6GB+128GB 全网通版（樱雪晴空）\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"华为畅享20 5G\",\"buttonMode\":\"10\",\"goodRate\":\"99\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"华为畅享20 5G\",\"photoName\":\"21B4AF84D0CA78847E127DFBBF4CBB32EA4AAD1345F94E0Dmp.png\",\"photoPath\":\"/product/6941487200191/\",\"picture3DPath\":\"\",\"price\":1499.0,\"priceAccurate\":1499.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086434489919,\"promoLabels\":[\"赠送积分\"],\"promotionInfo\":\"\",\"rateCount\":975,\"skuCode\":\"2601010229901\",\"skuCount\":12,\"skuName\":\"华为畅享20 5G 4GB+64GB 全网通版（亮黑色）\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"华为畅享20 Pro 5G\",\"buttonMode\":\"1\",\"displayTags\":\"热销爆款\",\"goodRate\":\"97\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"华为畅享20 Pro 5G\",\"photoName\":\"C089F3BE3BD266BAC2B777E1190F59241E0CE65223CA694Bmp.png\",\"photoPath\":\"/product/6972453165077/\",\"picture3DPath\":\"\",\"price\":1999.0,\"priceAccurate\":1999.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086226244792,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"赠送积分\"],\"promotionInfo\":\"购机赠耳机|预订省50\",\"rateCount\":1503,\"skuCode\":\"2601010222703\",\"skuCount\":8,\"skuName\":\"华为畅享20 Pro 6GB+128GB 全网通版（星河银）\",\"tagBgColor\":\"FF6A6E\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI nova 7 5G\",\"buttonMode\":\"1\",\"displayTags\":\"热销爆款\",\"goodRate\":\"97\",\"isInv\":1,\"mobileVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/c14a0aaa5285890807507131862/v.f118461.mp4\",\"name\":\"HUAWEI nova 7 5G\",\"photoName\":\"D294EE967746E5FDC3B80AA4E308C064B75F70818BB5BB17mp.png\",\"photoPath\":\"/product/6901443393268/\",\"picture3DPath\":\"\",\"price\":2999.0,\"priceAccurate\":2999.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086783311507,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"赠送积分\"],\"promotionInfo\":\"\",\"rateCount\":14314,\"skuCode\":\"2601010208704\",\"skuCount\":11,\"skuName\":\"HUAWEI nova 7 5G 前置3200万像素高清自拍 后置6400万变焦四摄  麒麟985 5G SoC 芯片 8GB+128GB 全网通版（7号色）\",\"tagBgColor\":\"FF6A6E\",\"webVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/c14a0aaa5285890807507131862/v.f118461.mp4\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI nova 7 Pro 5G\",\"buttonMode\":\"1\",\"displayTags\":\"热销爆款\",\"goodRate\":\"97\",\"isInv\":1,\"mobileVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/c14a0aaa5285890807507131862/v.f118461.mp4\",\"name\":\"HUAWEI nova 7 Pro 5G\",\"photoName\":\"58EAB4EFAF0C0396CD1E1B8CDD13FA7E0B5EFADD46080300mp.png\",\"photoPath\":\"/product/6901443393008/\",\"picture3DPath\":\"\",\"price\":3699.0,\"priceAccurate\":3699.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086163649385,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"分期免息\",\"赠送积分\"],\"promotionInfo\":\"享3期免息\",\"rateCount\":6884,\"skuCode\":\"2601010209401\",\"skuCount\":10,\"skuName\":\"HUAWEI nova 7 Pro 5G 前置3200万追焦双摄 50倍潜望式变焦四摄  麒麟985 5G SoC 8GB+128GB 全网通版（亮黑色）\",\"tagBgColor\":\"FF6A6E\",\"webVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/c14a0aaa5285890807507131862/v.f118461.mp4\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"HUAWEI P40 Pro+\",\"buttonMode\":\"1\",\"goodRate\":\"98\",\"isInv\":1,\"mobileVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/d6b452205285890800654415131/v.f20.mp4\",\"name\":\"HUAWEI P40 Pro+\",\"photoName\":\"C5B3EEB31BA081CF605FE04A1118DEF332F4C3003CC60ECEmp.png\",\"photoPath\":\"/product/6901443398027/\",\"picture3DPath\":\"\",\"price\":7988.0,\"priceAccurate\":7988.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086882694240,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"分期免息\",\"赠送积分\"],\"promotionInfo\":\"预订享多重优惠\",\"rateCount\":5239,\"skuCode\":\"2601010220301\",\"skuCount\":4,\"skuName\":\"HUAWEI P40 Pro+ 5G 全网通 8GB+256GB（陶瓷白）\",\"webVideoPath\":\"https://1251250874.vod2.myqcloud.com/439f276avodtransgzp1251250874/d6b452205285890800654415131/v.f20.mp4\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"麦芒 9 5G\",\"buttonMode\":\"1\",\"displayTags\":\"新品大屏5G\",\"goodRate\":\"97\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"麦芒 9 5G\",\"photoName\":\"A0F7A47E35110F7E695A3232D32344F0BBBF144D04917AAEmp.png\",\"photoPath\":\"/product/6972453166975/\",\"picture3DPath\":\"\",\"price\":2199.0,\"priceAccurate\":2199.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086607789867,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"赠送积分\"],\"promotionInfo\":\"赠精美礼券\",\"rateCount\":910,\"skuCode\":\"2601010226603\",\"skuCount\":6,\"skuName\":\"华为麦芒 9 5G 6GB+128GB 全网通（绮境森林）\",\"tagBgColor\":\"FF6A6E\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"华为畅享10\",\"buttonMode\":\"1\",\"goodRate\":\"98\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"华为畅享10\",\"photoName\":\"DE33DCDCE44B16C008868AC8AF5D1031CE1C2002031BB508mp.png\",\"photoPath\":\"/product/6901443349869/\",\"picture3DPath\":\"\",\"price\":1099.0,\"priceAccurate\":1099.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086835089299,\"promoLabels\":[\"以旧换新抵现\",\"赠送积分\"],\"promotionInfo\":\"\",\"rateCount\":12378,\"skuCode\":\"2601010155803\",\"skuCount\":16,\"skuName\":\"华为畅享10 4GB+64GB 全网通版（天空之境）\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"华为畅享 10e\",\"buttonMode\":\"1\",\"goodRate\":\"98\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"华为畅享 10e\",\"photoName\":\"C6960C20C53050E90CF1FA84EB7ADD6CA668F6987837B5E6mp.png\",\"photoPath\":\"/product/6972453160508/\",\"picture3DPath\":\"\",\"price\":999.0,\"priceAccurate\":999.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086365288993,\"promoLabels\":[\"一站式换新\",\"赠送积分\"],\"promotionInfo\":\"\",\"rateCount\":8159,\"skuCode\":\"2601010182201\",\"skuCount\":6,\"skuName\":\"华为畅享 10e 4GB+64GB 全网通版（幻夜黑）\",\"webVideoPath\":\"\"},{\"activeBeginTime\":\"\",\"activeEndTime\":\"\",\"briefName\":\"华为畅享Z 5G\",\"buttonMode\":\"1\",\"goodRate\":\"98\",\"isInv\":1,\"mobileVideoPath\":\"\",\"name\":\"华为畅享Z 5G\",\"photoName\":\"FA09FC63048E339DA47CDC56D7523C6C0125873D8D728F7Amp.png\",\"photoPath\":\"/product/6972453164933/\",\"picture3DPath\":\"\",\"price\":1699.0,\"priceAccurate\":1699.0,\"priceLabel\":2,\"priceMode\":1,\"productId\":10086891642017,\"promoLabels\":[\"一站式换新\",\"商品赠券\",\"赠送积分\"],\"promotionInfo\":\"赠耳机\",\"rateCount\":5649,\"skuCode\":\"2601010218403\",\"skuCount\":10,\"skuName\":\"华为畅享Z 5G 6GB+64GB 全网通版（樱雪晴空）\",\"webVideoPath\":\"\"}],\"resultType\":1,\"ruleId\":\"a2f51c094d41411897f5b1721acaed99\",\"sid\":\"58ee2bde6edfed135919af5e3666e2474073c25144f5303d\",\"success\":true,\"totalCount\":24,\"transferState\":0}"
//		val jsonObject = JSONObject(json)
//		val jsonArray = jsonObject.getJSONArray("resultList")
//		for (i in 0 until (jsonArray.length())){
//			val obj = jsonArray.getJSONObject(i)
//		}


	}


	@Test
	fun jsoupTest(){
		val document = get("https://www.vmall.com/list-111")
		val element = document.getElementsByTag("ul")
		println(element)
//		for (ele in element.getElementsByTag("li")) {
//			println(ele)
//		}
	}

	fun get(url : String) : Document {
		val httpClient = HttpClients.createDefault();//创建httpClient
		val httpGet = HttpGet(url);//创建httpget实例

		val response = httpClient.execute(httpGet);//执行get请求
		val entity = response.entity;//获取返回实体
		val content =  EntityUtils.toString(entity,"utf-8");//网页内容
		response.close();//关闭流和释放系统资源
		return Jsoup.parse(content);
	}

}
