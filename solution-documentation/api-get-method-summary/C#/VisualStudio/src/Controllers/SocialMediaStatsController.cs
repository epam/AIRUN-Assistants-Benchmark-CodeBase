using Microsoft.AspNetCore.Mvc;

namespace src.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class SocialMediaStatsController : ControllerBase
    {
        private static readonly string[] SocialMedias = new[]
        {
            "Facebook", "Twitter", "Instagram", "LinkedIn", "Snapchat", "Pinterest", "Reddit", "Tumblr", "Flickr", "Quora"
        };

        private readonly ILogger<SocialMediaStatsController> _logger;

        public SocialMediaStatsController(ILogger<SocialMediaStatsController> logger)
        {
            _logger = logger;
        }
        
        [HttpGet()]
        public IEnumerable<Stat> GetMostTrendingSM()
        {
            return Enumerable.Range(1, 5).Select(index => new Stat
            {
                Site = SocialMedias[Random.Shared.Next(SocialMedias.Length)],
                OnlineUsers = Random.Shared.Next(0, 10000000),
                TotalUsers = Random.Shared.Next(1000, 10000000),
                IsDown = false
            })
            .ToArray();
        }
    }
}