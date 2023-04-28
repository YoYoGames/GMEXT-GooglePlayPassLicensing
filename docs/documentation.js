// FUNCTIONS

/** 
 * @func GooglePlayPassLicensing_CheckLicense
 * @desc Use this functio to check if the current user is licensed or not. If the user is not subscribed a paywall will be shown so they can subscribe.
 * 
 * @event social
 * @desc Triggered if the user is subscribed to the play pass.
 * @member {string} type The value `"GooglePlayPassLicensing"`
 * @member {string} event The value `"LICENSED"`.
 * @event_end
 * 
 * @event social
 * @desc Triggered if the user is not subscribed to the play pass.
 * @member {string} type The value `"GooglePlayPassLicensing"`
 * @member {string} event The value `"NOT_LICENSED"`.
 * @member {boolean} value Wheather or not the paywall has been shown to the user.
 * @event_end
 * 
 * @event social
 * @desc Triggered if there was an error checking for the license.
 * @member {string} type The value `"GooglePlayPassLicensing"`
 * @member {string} event The value `"ERROR"`.
 * @member {string} value The error message.
 * @event_end
 * 
 * @func_end
 */
function GooglePlayPassLicensing_CheckLicense() {}

/** 
 * @module home
 * @title Home
 * @desc Google Play Pass is a subscription-based service offered by Google for Android devices that provides access to a collection of premium apps and games without ads or in-app purchases. With Google Play Pass, subscribers can download and use a wide range of apps and games, including popular titles such as Monument Valley, Stardew Valley, and Limbo, among others. The service is available for a monthly fee and includes a free trial period. Google Play Pass is designed to offer users an affordable and convenient way to discover and enjoy high-quality apps and games on their Android devices.
 * 
 * By using this extension, you can verify whether a particular user has subscribed to Google Play Pass.
 * @section_func
 * @ref GooglePlayPassLicensing_CheckLicense
 * @section_end
 * @module_end
 */
