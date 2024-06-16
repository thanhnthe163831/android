package Slot11;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceDel {
    @FormUrlEncoded
    @POST("delete_product.php")
    Call<SvrResponseDel> deleteExe(@Field("pid") String pid);
}
