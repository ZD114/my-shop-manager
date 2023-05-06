import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description:
 * @auther: zd
 * @date: 2023/5/6
 **/
@FeignClient(name = "shop-goods")
public interface GoodsServiceClient {
}
