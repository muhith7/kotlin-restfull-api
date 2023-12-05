package com.plugin.id.config

import com.cloudinary.Cloudinary
import com.cloudinary.utils.ObjectUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CloudinaryConfig {
    @Bean
    fun cloudinaryAccount () : Cloudinary {
        return Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dtjd1zwaf",
            "api_key", "923676546945556",
            "api_secret", "nhc7H5N7PVmzVk6LCRrxxiKYcfc"
        ))
    }
}